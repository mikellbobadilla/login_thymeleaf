FROM alpine:3.17.3
WORKDIR /app
RUN apk add openjdk17
COPY target/*.jar application.jar
ENTRYPOINT ["java","-jar","/app/application.jar"]