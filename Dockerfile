# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built Spring Boot application JAR file into the container
COPY target/SpringDataJpaDocker-0.0.1-SNAPSHOT.jar app.jar

# Expose the application's port
EXPOSE 8080

# Define environment variables for database connection
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/dockerVersion \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=password

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
