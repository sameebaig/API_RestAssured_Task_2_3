## Task 2&3 - API Automation Testing with Rest Assured

Project Overview

This project is part of a QA Automation task that focuses on API Testing using Rest Assured, TestNG, and Maven.
The objective is to automate CRUD (Create, Read, Update, Delete) operations on a public REST API (https://reqres.in/api) and validate responses through assertions and reporting.

Key Features

✅ Automated REST API Testing using Rest Assured
✅ Configuration managed via properties file(routes.properties)
✅ Logging of requests & responses
✅ Assertions for status codes and response fields
✅ Modular and reusable endpoint structure
✅ Reporting

## Project File structure

"""

APIAutomationRestAssured/
│
├── pom.xml
├── testng.xml
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   └── api/
│   │   │       ├── endpoints/
│   │   │       │   ├── Routes.java
│   │   │       │   └── UserEndPoints.java
│   │   │       │
│   │   │       ├── hooks/
│   │   │       │   └── TestListener.java
│   │   │       │
│   │   │       ├── payload/
│   │   │       │   └── (if needed for JSON bodies)
│   │   │       │
│   │   │       ├── test/
│   │   │       │   ├── PostApi.java
│   │   │       │   ├── UserTests.java
│   │   │       │   
│   │   │       │
│   │   │       └── utilities/
│   │   │           └── ConfigReader.java
│   │   │
│   │   └── resources/
│   │       └── routes.properties
│
├── reports/                     
├── target/                     
└── test-output/   

"""

## Configuration (routes.properties)

base_url=https://reqres.in/api
api_key=reqres-free-v1
getUser=/users/{id}
createUser=/users
updateUser=/users/{id}
deleteUser=/users/{id}

## Tools
 Tool                                                             
| ----------------------------------- 
| **Java**                           
| **Rest Assured** (API testing framework)           
| **TestNG**                         
| **Maven**                          
| **Reports**

## CLI commands
mvn clean test

    ├── surefire-reports/             # Maven/TestNG reports
    └── test-output/                  # TestNG default HTML report
