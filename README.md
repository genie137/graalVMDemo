# Demo Native Spring boot application.

## For Ubuntu 22.10

### Prepare:
1. Install Docker Engine - https://docs.docker.com/engine/install/ubuntu/
2. Install build-essentials `sudo apt install build-essential`
3. Install SDKMan - https://sdkman.io/ (`curl -s "https://get.sdkman.io" | bash`)
4. Install Liberica NIK SDK (`sdk install java 22.3.r17-nik`)
5. Install Maven (`sdk install maven 3.8.7`)

### Build with scripts:
1. Login to docker hub: `docker login` (Create account here: https://hub.docker.com/) and create two repositories. 
2. Change the `plugin.configuration.to.image` in the pom.xml and the `spec.template.spec.containers.image` in the helm/templates/deployment.yaml to your own docker hub location!
3. Determine script to use:
   1. `build-native` = Build a native image and push to docker hub.
   2. `build-native-deploy-oc` = Build a native image and push to docker hub, and deploy to local Openshift.
   3. `build-normal` = Build a 'normal' image and push to docker hub.
   4. `build-normal-deploy-oc` = Build a 'normal' image and push to docker hub, and deploy to local Openshift.
4. If deploying to Openshift, login: `oc login --token=<TOKEN> --server=<SERVER>`
5. Add executable flag to script: `chmod +x scripts/<SCRIPT>`
6. Execute script: `./scripts/<SCRIPTS>`

### Build manually:
1. Login to docker hub: `docker login` (Create account here: https://hub.docker.com/) (needed for the base image)
2. Set the sdk: `sdk use java 22.3.r17-nik`
3. Build the image:
   1. Native: `mvn package -Pnative`
   2. Normal: `mvn package -Pnormal`
4. Package the image (edit the `plugin.configuration.to.image`!!)
   1. Push native to dockerHub: `mvn jib:build -Pnative`
   2. Push native to local docker-engine images: `mvn jib:dockerBuild -Pnative`
   3. Push normal to dockerHub `mvn jib:build -Pnormal`
   4. Push native to local docker-engine images: `mvn jib:dockerBuild -Pnormal`

### Run Image:

- Run native image locally: `./target/graalvmdemo-native`
- Run image from local docker-engine images: `docker run <IMAGE>:latest`
   - See installed images: `docker image ls`
- Run trough docker from dockerhub: `docker pull <IMAGE>:latest && docker run <IMAGE>:latest `

### Run from chart:
1. Change the `spec.template.spec.containers.image` to your own docker hub location, same as build manually step 4)
2. Package the chart: `helm package helm`
3. If deploying to Openshift, login: `oc login --token=<TOKEN> --server=<SERVER>`
4. Install in the cluster:
   1. Native image: `helm upgrade --install <RELEASE_NAME> graalVmChart-0.0.1.tgz --set native=True`
   2. Normal image: `helm upgrade --install <RELEASE_NAME> graalVmChart-0.0.1.tgz --set native=False`