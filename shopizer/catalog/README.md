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
