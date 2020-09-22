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

## Run catalog api on postgres sql

```sh
docker network create --driver bridge db

docker rm shopizer-postgres

docker run --name shopizer-postgres --network db -v /Users/carlsamson/Documents/dev/workspaces/volumes/datadir:/var/lib/postgresql/data -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres:latest

docker stop shopizer-postgres
docker start shopizer-postgres

# postgres client
docker run -it --rm --network db postgres psql -h shopizer-postgres -U postgres

# create database shopizer
CREATE DATABASE "SHOPIZER" WITH OWNER "postgres" ENCODING 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8' TEMPLATE template0;

# connect on new database
\connect SHOPIZER

#create schena
create schema salesmanager;
```

Run Catalog services

From that point i use DBEAVER sql client

