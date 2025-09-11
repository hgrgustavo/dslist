#!/bin/zsh

get_compose_extension() {
  local compose_file
  for file in docker-compose.y{a,}ml docker-compose.json; do
    if [[ -f "$file" ]]; then
      compose_file="$file"
      break
    fi
  done
  if [[ -n "$compose_file" ]]; then
    echo "${compose_file##*.}"
  else
    echo "Compose file not found. Please create one."
    exit 130
  fi
}

echo "Binding environment variables..."
source $PWD/.env

echo "Initializing Docker daemon..."
if ! systemctl is-active --quiet docker; then
  echo "Docker is inactive. Starting..."
  sudo systemctl start docker
fi

echo "Formatting compose file..."
docker compose config -q --format "$(get_compose_extension)"

echo "Loading containers..."
sudo docker compose up -d
