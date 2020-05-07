MVN := ./mvnw

.PHONY: dev prep up compile-docker-native build-image compile-current-os-native

dev:
	${MVN} compile quarkus:dev
run: prep up
# dirty build
prep:
	docker-compose pull
build:
	${MVN} clean package
	docker-compose build bysykkel2minio
up:
	docker-compose up -d
up-minio:
	docker-compose up -d minio
create-bucket:
	docker-compose up mc
up-bysykkel2minio:
	docker-compose up -d bysykkel2minio

### Native image build Work In Progress
# native image runtime has issue currently, check github issue for project
bi: compile-docker-native build-image
compile-current-os-native:
	${MVN} clean package -Pnative
# compile inside container for Linux OS
compile-docker-native:
	${MVN} package -Pnative -Dquarkus.native.container-build=true \
      -Dquarkus.native.container-runtime=docker
build-image:
	docker build -f src/main/docker/Dockerfile.native -t zhenik/passtry-minio-gen:1.00 .
