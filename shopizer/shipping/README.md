

## WIP shipping microservices


### For building images

TODO specify Google java 8 distroless https://github.com/GoogleContainerTools/distroless/tree/master/java
Built with Java 11

open api v3

http://localhost:8080/v3/api-docs/
http://localhost:8080/swagger-ui.html

https://github.com/thombergs/code-examples/blob/master/spring-boot/spring-boot-springdoc/src/main/java/io/reflectoring/codefirst/CodeFirstApplication.java

## Build image

```sh
cd shipping
mvnw clean package && java -jar ./target/*.jar
mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=shopizerecomm/shipping-api:latest
docker run -d -p 9091:8080 --name shipping shopizerecomm/shipping-api:latest
docker push shopizerecomm/shipping-api:latest

curl http://localhost:9090/actuator
```