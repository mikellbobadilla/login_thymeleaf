FROM alpine:3.17.3
WORKDIR /app
RUN apk add openjdk17
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/target/login_thymeleaf-1.0.0.jar"]