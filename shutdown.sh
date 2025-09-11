#!/bin/zsh

echo "Stopping containers..."
sudo docker compose stop

echo "Stopping docker service..."
sudo systemctl stop docker
