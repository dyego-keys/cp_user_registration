FROM openjdk:11

# Specify JAR location
ARG JAR_FILE=target/*.jar

# Copy the JAR
COPY ${JAR_FILE} reguser.jar

# Set ENTRYPOINT in exec form to run the container as an executable
ENTRYPOINT ["java","-jar","/reguser.jar"]