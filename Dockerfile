FROM openjdk:17-jdk-alpine
EXPOSE 80
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} .
CMD [ "java", "-jar",  "/demo-0.0.1-SNAPSHOT.jar"]