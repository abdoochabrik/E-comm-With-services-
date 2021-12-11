FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/config-server*.jar /app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]