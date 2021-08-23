
#### Stage 1: Build the application
FROM openjdk:8-jdk-alpine as build
COPY assets/settings.xml /tmp/settings.xml
ENV PATH=$PATH:/opt/maven/bin

RUN apk add --no-cache curl tar bash && \
  curl -SsL -o /tmp/maven.tar.gz http://www-us.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz && \
  mkdir -p /opt && \
  tar xzf /tmp/maven.tar.gz -C /opt/ && \
  ln -s /opt/apache-maven-3.3.9 /opt/maven && \
  rm /tmp/maven.tar.gz && \
  mv /tmp/settings.xml /opt/maven/conf/settings.xml
  
RUN mvn clean install
RUN mvn package
ARG JAR_FILE=target/*.jar
# Copy project dependencies from the build stage
COPY ${JAR_FILE} sabre-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","/sabre-0.0.1-SNAPSHOT.jar"]
#RUN addgroup -S spring && adduser -S spring -G spring





