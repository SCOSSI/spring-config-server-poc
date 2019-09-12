FROM openjdk:8-jdk-alpine
ARG JAR_FILE
RUN configserver/gradlew build
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]