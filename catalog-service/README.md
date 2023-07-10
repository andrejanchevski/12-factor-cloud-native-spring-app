# catalog-service

# Commands for Running the Service

1. "./gradlew test" - Running the tests for Catalog Service
2. "./gradlew bootRun" - Runnint the Catalog Service (on default port 8080)

# Running in Docker Container
1. "./gradlew bootBuildImage"
2. "docker run --rm --name catalog-service -p 8080:8080 catalog-service:0.0.1-SNAPSHOT"

# Running in Kubernetes
1. For local running have minikube running locally
2. minikube image load catalog-service:0.0.1-SNAPSHOT
   * Loading the image into minikube from the local machine
   * It is important to execute ./gradlew bootBuildImage first to get the image locally using Cloud Native Buildpacks
3. kubectl create deployment catalog-service --image=catalog-service:0.0.1-SNAPSHOT
4. kubectl expose deployment catalog-service --name=catalog-service --port=8080
5. kubectl port-forward catalog-service 8080:8080
   5.1. The first port is the local port


# Useful Kubernetes Commands for Running and checking Catalog Service
1. kubectl config current-context - List the current context we are working with (Kubectl can work with multiple clusters)
2. kubectl get contexts - Displaying all context which kubectl has worked with
3. kubectl get namespaces - Displaying all Namespaces in the Cluster
4. kubectl get services - Displaying all Services in the Cluster
5. kubectl get svc -l app=catalog-service - All services in the Cluster with the provided selector
6. kubectl get deployments - All deployments in the cluster
7. kubectl get pods - All pods (containers) running in the cluster
8. kubectl apply -f k8s/deployment.yml - Adding Deployment to the Cluster
9. kubectl apply -f k8s/service.yml - Adding Service to the Cluster
10. kubectl logs deployment/catalog-service - Logs for a specific deployment
11. kubectl port-forward service/catalog-service 9001:80 - Portforward to reach the service
12. minikube image ls - Fetch Loaded Images Into minikube


# Starting Config Service, Catalog Service and Order Service without API Gateway
1. minikube start --cpus 2 --memory 4g --driver docker --profile polar
   * Starting A Local Cluster Using Minikube
2. minikube image ls
   * Checking the loaded images
   * Specify profile --profile polar
3. Navigate to catalog-service and execute ./gradlew bootBuildImage
4. Navigate to order-service and execute ./gradlew bootBuildImage
5. Navigate to config-service and execute ./gradlew bootBuildImage
6. minikube image load catalog-service --profile polar
7. minikube image load order-service --profile polar
8. minikube image load config-service --profile polar
   * Check Maybe the Images have been loaded already on minikube
9. Navigate to /polar-deployment/kubernetes/platform/development and enter kubectl apply -f services
10. Navigate to /polar-deployment/kubernetes/applications/development and enter tilt up




