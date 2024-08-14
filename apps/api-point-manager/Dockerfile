FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8000

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]