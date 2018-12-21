FROM openjdk:8-jdk-alpine
ADD target/*.jar app.jar
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8082