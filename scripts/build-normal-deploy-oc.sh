#!/usr/bin/zsh

export SDKMAN_DIR="$HOME/.sdkman"
[[ -s "$HOME/.sdkman/bin/sdkman-init.sh" ]] && source "$HOME/.sdkman/bin/sdkman-init.sh"

sdk use java 22.3.r17-nik
mvn package jib:build -Pnormal
helm package helm
helm upgrade --install test-native graalVmChart-0.0.1.tgz --set native=False