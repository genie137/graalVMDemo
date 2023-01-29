# Demo Native Spring boot application.

## For Ubuntu 22.10

### Prepare:
1. Install Docker Engine - https://docs.docker.com/engine/install/ubuntu/
2. Install build-essentials `sudo apt install build-essential`
3. Install SDKMan - https://sdkman.io/ (`curl -s "https://get.sdkman.io" | bash`)
4. Install Liberica NIK SDK (`sdk install java 22.3.r17-nik`)
5. Install Maven (`sdk install maven 3.8.7`)

### Build:
1. Login to docker hub: `docker login` (Create account here: https://hub.docker.com/)
2. Determine script to use:
   1. `build-native` = Build a native image and push to docker hub.
   2. `build-native-deploy-oc` = Build a native image and push to docker hub, and deploy to local Openshift.
   3. `build-normal` = Build a 'normal' image and push to docker hub.
   4. `build-normal-deploy-oc` = Build a 'normal' image and push to docker hub, and deploy to local Openshift.
3. If deploying to Openshift, login: `oc login --token=<TOKEN> --server=<SERVER>`
4. Add executable flag to script: `chmod +x scripts/<SCRIPT>`
5. Execute script: `./scripts/<SCRIPTS>`

### Run:

- Run native image locally: `./target/graalvmdemo-native`
- Run trough docker from dockerhub: `docker pull <IMAGE>:latest && docker run <IMAGE>:latest `
- 