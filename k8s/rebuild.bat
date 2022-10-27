kubectl delete -f .\gateway.yaml -f .\treatment.yaml -f .\patien.yaml -f .\seizure.yaml
cd ../patient
docker build -t venjilin/patient:latest .
docker push venjilin/patient:latest
cd ../treatment
docker build -t venjilin/treatment:latest .
docker push venjilin/treatment:latest
cd ../seizure
docker build -t venjilin/seizure:latest .
docker push venjilin/seizure:latest
cd ../gateway
docker build -t venjilin/gateway:latest .
docker push venjilin/gateway:latest
cd ../k8s
kubectl apply -f .\gateway.yaml -f .\treatment.yaml -f .\patien.yaml -f .\seizure.yaml
