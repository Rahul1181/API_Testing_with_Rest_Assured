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

## Maven Dependencies
- io.rest-assured
- org.testng
- com.googlecode.json-simple

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

## Local Server Setup
- Check if you have npm and node.js package installed in cmd and if not then install it
    - `npm -v` -> Check the npm version
    - `node -v`-> Check the node.js version
- Run cmd as Administrator and paste the cmd : `npm install -g json-server@0.17.4` -> Install the JSON Server in local
- Then paste " `json-server --watch db.json` -> Starts the JSON server
- You will have *db.json* created in the directory where you ran the cmd command
- Copy and paste the local host URL: `http://localhost:3000/`
- Now run and enjoy

## Setup JSON Schema Validation
1. Why do we need to JSON Schema Validation?
Ans: JSON Schema testing ensures that the API response structure (contract) is correct and stable, independent of the actual data values.
It checks:
    - Missing fields
    - Renamed fields
    - Wrong data types 
    - Unexpected structure changes
This is critical when:
    - Data is dynamic
    - IDs and timestamps change every run

2. What JSON Schema Validation Checks ?

|Check                  |  Example              |
|---|---|
|Field existence	    | id must exist         |
|Data type              | id must be integer    |
|Required fields        | name, email           |
|Array vs object        | users must be array   |
|Nested structure       | address.city          |
|Enum values	        | status ∈ [active, inactive] |
|Additional fields      | Optional / forbidden  |

3. Setup: 
- Goto : [JSON to JSON Schema Converter](https://www.liquid-technologies.com/online-json-to-schema-converter)
- Goto: [Reqres](https://reqres.in/) and copy one of the JSON response
- Paste the response in JSON schema generator
- Goto target/classes and paste the code in schemaUserData.json (This is adding JSON FILE IN CLASSPATH)
- Get the [JSON schema Validator Repo](https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator) and paste in POM file
- Run the code `JsonSchemaValidator.java`










