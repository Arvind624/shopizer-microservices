## Catalog api

http://localhost:8080/actuator

## build docker image

```sh
cd catalog
mvnw clean package && java -jar ./target/*.jar
mvnw spring-boot:build-image
docker run -p 9090:8080 -t docker.io/library/catalog:0.0.1-SNAPSHOT

curl http://localhost:9090/actuator
```

//-Dspring.cloud.config.uri=http://localhost:8071 \
//-Dspring.profiles.active=dev \

docker network create --driver bridge db

docker run --name shopizer-postgres --network shopizer -v /Users/carlsamson/Documents/dev/workspaces/microservices/volume/datadir:/var/lib/postgresql/data -e POSTGRES_PASSWORD=password -d postgres:latest


