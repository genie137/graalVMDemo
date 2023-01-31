#!/usr/bin/zsh

helm package helm
helm upgrade --install test-native graalVmChart-0.0.1.tgz --set native=True