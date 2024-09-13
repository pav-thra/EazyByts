# Build stage
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven configuration file
COPY pom.xml .

# Download dependencies (this step helps to cache dependencies)
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Package the application (creates the .jar file)
RUN mvn clean package -DskipTests

# Debug: List target directory contents to confirm JAR file creation
RUN ls -al /app/target/

# Final stage
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the current working directory
COPY --from=build /app/target/CRM-0.0.1-SNAPSHOT.jar .

# Expose the port on which the app will run
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "CRM-0.0.1-SNAPSHOT.jar"]
