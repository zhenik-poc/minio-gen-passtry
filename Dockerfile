# }===|==>----
# Dirty crutch, until I fix native image
FROM openjdk:8-alpine
COPY ./target /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ["java", "-jar", "scheduler-minio-1.0-SNAPSHOT-runner.jar"]
