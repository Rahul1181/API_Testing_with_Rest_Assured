# API Testing with Rest Assured 

1. What is REST?
- Rest or **Representational State Transfer** is a Java Library or Java API for testing Restful Web services.
- Rest is used to run or invoke REST web services and validate response
- Used to test XML or JSON based web services. 
- Supports HTTPS method like **GET, POST, PUT, DELETE, OPTIONS, PATCH AND HEAD** 
- Can integrate with TestNG or Junit. 
- **Rest is implemented in Groovy**

2. What is Groovy?
- Groovy is a JVM-based dynamic language that is fully compatible with Java. It is used in Jenkins pipelines, Gradle build scripts, and frameworks like Spock.

## Prerequisites
- Language - *Java*
- IDE - *VS code*
- Dependency Management Tool - *Maven*
- Framework - *TestNG*

## Helpful Tools
- [JSON Path Finder](https://jsonpathfinder.com/)

## Website for Testing
- [Dev community](https://dev.to/mdmoeenajazkhan/api-testing-demo-site-1ef5)
- [Reqres](https://reqres.in/)

## How to set API key in REQRES in Windows?
- Create an account in [Reqres](https://reqres.in/)
- Go to [API Key](https://app.reqres.in/api-keys)
- Create New API key and give this a name 
- Copy the API key and save it in local
- Open CMD and paste the following command
    - `setx REQ_RES_API_KEY="**YOUR_API_KEY**"`
- Close CMD and rerun
- Use command `echo %REQ_RES_API_KEY%` and check if you get your API key
- Now create a "EnvironmentConfig.java" file and add the details of API Key in it
- And all set!!









