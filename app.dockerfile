FROM maven:3.5-jdk-8-alpine
COPY pom.xml .
COPY src ./src
RUN mvn clean package

COPY target/demo-chat-app-0.0.1-SNAPSHOT.jar demo-chat-app-1.0.0.jar
ENTRYPOINT ["java","-jar","/demo-chat-app-1.0.0.jar"]