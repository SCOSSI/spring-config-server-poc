FROM openjdk:8-jdk-alpine AS BUILD_IMAGE
WORKDIR /app
ADD . /app
RUN ls
RUN ./gradlew clean build --stacktrace

FROM openjdk:8-jre-alpine
COPY --from=BUILD_IMAGE /app/build/libs/configserver.jar .
ENTRYPOINT ["java","-jar","configserver.jar"]
