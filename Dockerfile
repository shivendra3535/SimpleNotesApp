FROM openjdk:21

WORKDIR /app

COPY target/SimpleNotesApp-0.0.1-SNAPSHOT.jar /app/SimpleNotesApp-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "SimpleNotesApp-0.0.1-SNAPSHOT.jar"]