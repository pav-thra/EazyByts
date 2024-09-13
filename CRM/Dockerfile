# Use the official Maven image to build the application
FROM maven:3.8.4-jdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven configuration file
COPY pom.xml .

# Download dependencies (this step helps to cache dependencies)
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Package the application (creates the .jar file)
RUN mvn clean package

# Use a smaller base image to run the application
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the current working directory
COPY --from=build /app/target/EazyByts.jar .

# Expose the port on which the app will run
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "EazyByts.jar"]

# Build the Docker image
docker build -t eazybyts .

# Run the Docker container
docker run -p 8080:8080 eazybyts

