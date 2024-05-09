FROM openjdk:8-jre-alpine AS base
WORKDIR /app
EXPOSE 8080

FROM maven:3.5.0-jdk-8-alpine AS build
WORKDIR /src
COPY ["pom.xml", "."]
RUN mvn clean install
COPY . .
RUN mvn package

FROM base AS final
WORKDIR /app
COPY --from=build /src/target/BasicEnvironmentStatistics-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Djava.net.preferIPv4Stack=true", "-jar","app.jar"]
