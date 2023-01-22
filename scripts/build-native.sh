#!/usr/bin/zsh
cd "$HOME/WS/graalVMDemo/"

export SDKMAN_DIR="$HOME/.sdkman"
[[ -s "$HOME/.sdkman/bin/sdkman-init.sh" ]] && source "$HOME/.sdkman/bin/sdkman-init.sh"

sdk use java 22.3.r17-nik
mvn package jib:build -Pnative
helm package helm
helm upgrade --install test-native graalVmChart-0.0.1.tgz --set native=True