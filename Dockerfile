FROM alpine:3.17.3
WORKDIR /app
RUN apk add openjdk17 && apk add maven
COPY . /app
RUN mvn clean && mvn install
ENTRYPOINT ["java","-jar","/app/target/login_thymeleaf-1.0.0.jar"]