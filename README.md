# <img src="https://github.com/tino097/awesome-spring-boot-rest-api/raw/master/spring-logo.png" align="absmiddle"/>User Registration Rest API for Counties Power Tech Test

[![Wercker](https://img.shields.io/badge/spring--boot-2.1.5.RELEASE-green.svg?style=flat-square&logo=spring)](https://spring.io/projects/spring-boot)
[![Wercker](https://img.shields.io/badge/java-11-blue.svg?style=flat-square&logo=java)](https://openjdk.java.net/install/)

## Table of contents

1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Development](#development)
4. [Explore](#explore)
5. [Test](#Test)

## Introduction

Spring Boot Rest User registration API for Counties Power Tech Test

## Prerequisites

- Java 11
- Maven 3

---

## Development

Please clone or fork the repo:

    git clone https://github.com/dyego-keys/cp_user_registration.git

To build the project execute the following command:

    ./mvn package

To run the project execute the following command:

    ./java -jar register-0.0.1-SNAPSHOT.jar

## Explore

The app defines following API's endpoints.

    POST /users/login
        BODY
            {
                "email":"{email}",
                "password":"{password}"
            }
            
    GET /users?lastName={lastName}&size={size}&page={page}
    
        Optionals:
            lastName, size (default=3), page (default=0)
    
    GET users/{userId}
        
    POST /users
        BODY
            {
                "firstName":"{firstName}",
                "lastName":"{lastName}",
                "email":"{email}",
                "password":"{password}"
            }

## Test

**Test user:**

    First Name: John
    Last Name: Smith
    Email: john.smith@countiespower.com
    Password: password
    
**Test URL:** http://ec2-13-211-167-240.ap-southeast-2.compute.amazonaws.com 

**Login**:
    
    POST http://ec2-13-211-167-240.ap-southeast-2.compute.amazonaws.com:8080/users/login
    
    BODY
        {
            "email":"root@countiespower.com",
            "password":"password"
        }
    
    RESPONSE
        {
            "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkeWVnby5jaGF2ZXpAZ21haWwuY29tIiwiZXhwIjoxNTk3NjEwM...."
        }
        
**Copy the token received from the last call to the rest of the header's calls**
    
**Get all users:**
    
    GET http://ec2-13-211-167-240.ap-southeast-2.compute.amazonaws.com:8080/users?size=100
    
    HEADER:
        Authorization: "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkeWVnby5jaGF2ZXpAZ21haWwuY29tIiwiZXhwIjoxNTk3NjEwM...."
        
    
**Get users by Last Name:**

    GET http://ec2-13-211-167-240.ap-southeast-2.compute.amazonaws.com:8080/users?lastName=Robertson
    
    HEADER:
        Authorization: "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkeWVnby5jaGF2ZXpAZ21haWwuY29tIiwiZXhwIjoxNTk3NjEwM...."
    
**Post new user:**

    POST http://ec2-13-211-167-240.ap-southeast-2.compute.amazonaws.com:8080/users
    
    HEADER:
        Authorization: "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkeWVnby5jaGF2ZXpAZ21haWwuY29tIiwiZXhwIjoxNTk3NjEwM...."
        
