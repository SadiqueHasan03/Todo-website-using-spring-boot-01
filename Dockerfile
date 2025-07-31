FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

# ✅ Make mvnw executable
RUN chmod +x mvnw

# ✅ Build the project
RUN ./mvnw clean package -DskipTests

# ✅ Expose port and run the app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/todo-0.0.1-SNAPSHOT.jar"]
