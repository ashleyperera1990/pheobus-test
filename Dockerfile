FROM openjdk:8-jdk-alpine
MAINTAINER aperera
COPY target/test-0.0.1-SNAPSHOT.jar pheobus-test-1.0.0.jar
ENTRYPOINT ["java","-jar","/pheobus-test-1.0.0.jar"]
