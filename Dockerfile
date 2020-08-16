# Build stage
#
FROM maven:latest AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:11
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
COPY --from=build /home/app/target/register-0.0.1-SNAPSHOT.jar reguser.jar
ENTRYPOINT ["java","-jar","/reguser.jar"]

## Specify JAR location
#ARG JAR_FILE=target/register-0.0.1-SNAPSHOT.jar
#
## Copy the JAR
#COPY ${JAR_FILE} reguser.jar
#
## Set ENTRYPOINT in exec form to run the container as an executable
#ENTRYPOINT ["java","-jar","/reguser.jar"]