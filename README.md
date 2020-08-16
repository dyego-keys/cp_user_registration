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

Spring Boot is an extension of the Spring framework. It can be used to skip boilerplate code for configuring the applications.
In this example we will use its powerful and easy approach to give an example of how to build awesome REST API.

For that purpose we will create an application which can be used as Company catalogue. We will be able to add, edit and delete companies and expose
REST endpoint for that purpose. Additionally it will be an option to add Owners or Industries to specific company

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

The app defines following CRUD APIs.

    GET /users
    
    GET users/{userId}
    
    GET users?lastName={lastName} (optional)
    
    GET users?size={size} (optional, size = 3)
    
    GET users?psge={page} (optional, page = 0)
    
    POST /users

## Test

Login:
    
    POST http://ec2-13-211-167-240.ap-southeast-2.compute.amazonaws.com:8080/users/login
    
Get all users:
    
    GET http://ec2-13-211-167-240.ap-southeast-2.compute.amazonaws.com:8080/users?size=100
    
Get users by Last Name:

    GET http://ec2-13-211-167-240.ap-southeast-2.compute.amazonaws.com:8080/users?lastName=Robertson
    
Post new user:

    POST http://ec2-13-211-167-240.ap-southeast-2.compute.amazonaws.com:8080/users

    
    
    

