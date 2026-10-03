FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY bff-mobile/target/bff-mobile-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
