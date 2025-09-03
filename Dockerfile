# Use official OpenJDK image
FROM openjdk:21

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY . .

# Package the app (skip tests for speed)
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/SimpleNotesApp-0.0.1-SNAPSHOT.jar"]
