FROM openjdk:8-jdk-alpine AS BUILD_IMAGE
WORKDIR /app
ADD . /app
RUN ./gradlew clean build --stacktrace

FROM openjdk:8-jre-alpine
COPY --from=BUILD_IMAGE /app/build/libs/client-service.jar .
ENTRYPOINT ["java","-jar","client-service.jar"]
