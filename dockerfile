#### Stage 1: Build the application
FROM maven:3.8-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn install

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
# Copy project dependencies from the build stage
COPY ${JAR_FILE} sabre-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","/sabre-0.0.1-SNAPSHOT.jar"]
#RUN addgroup -S spring && adduser -S spring -G spring


