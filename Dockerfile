FROM alpine:3.17.3
WORKDIR /app
RUN apk add openjdk17
RUN apk add maven
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
