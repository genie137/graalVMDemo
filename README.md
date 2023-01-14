# Prepare:

## For WSL2 - Windows 11 & Ubuntu 22.04
1. Setup WSL2 with Ubuntu 22.04 (Microsoft Store)
2. Install Docker Desktop and login to docker hub - https://www.docker.com/products/docker-desktop/
3. Install `build-essential zlib1g-dev`
4. Install SDKMan - https://sdkman.io/ (`curl -s "https://get.sdkman.io" | bash`)
5. Install Liberica NIK SDK (`sdk install java 22.3.r17-nik`)

# Build:

## For Windows using Docker Desktop in WSL2:
Fix docker credentials: `nano ~/.docker/config.json` and remove auth provider.

## Build the thing:
1. Set Liberica NIK SDK: `sdk use java 22.3.r17-nik`
2. Build: `mvn package jib:dockerBuild -Pnative`

## Run the thing:
1. Start container from docker desktop, open ports.

