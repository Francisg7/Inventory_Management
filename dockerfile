FROM maven:onbuild AS buildenv


#### Stage 1: Build the application
FROM openjdk:8-jdk-alpine as build
RUN mvn clean install
RUN mvn package
ARG JAR_FILE=target/*.jar
# Copy project dependencies from the build stage
COPY --from=buildenv ${JAR_FILE} sabre-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","/sabre-0.0.1-SNAPSHOT.jar"]
#RUN addgroup -S spring && adduser -S spring -G spring





