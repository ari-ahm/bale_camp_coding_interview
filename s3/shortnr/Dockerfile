FROM eclipse-temurin:17-jre-alpine

COPY target/*-jar-with-dependencies.jar /opt/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]

