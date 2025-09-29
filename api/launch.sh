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
    echo " Compose file not found. Please create one."
    exit 130
  fi
}

echo -n " ⚙️ Binding environment variables..."
source ./.env
echo " done."

sudo systemctl -q start docker
echo -n " 🐋 Providing docker containers..."
docker compose config -q --format "$(get_compose_extension)"
sudo docker compose up -d --quiet-build --quiet-pull
echo " done."

echo -n " 🌱 Building Spring project... done."
./mvnw spring-boot:run -DskipTests
