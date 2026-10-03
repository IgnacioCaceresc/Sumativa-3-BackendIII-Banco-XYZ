FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY bff-web/target/bff-web-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
