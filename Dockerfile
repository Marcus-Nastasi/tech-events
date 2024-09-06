FROM openjdk:21-oracle

WORKDIR /app
COPY eventostech-0.0.1-SNAPSHOT.jar /app/eventostech-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/eventostech-0.0.1-SNAPSHOT.jar"]
