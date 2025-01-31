
FROM openjdk:17-jdk-slim
COPY target/fraud-mgnt-service-0.0.1-SNAPSHOT.jar fraud-mgnt-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/fraud-mgnt-service.jar"]

