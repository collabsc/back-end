# backend

Back-end system for CollabSC. Uses Spring Boot framework and H2 database to manage and maintain users and projects.


## Setup

1. Install the Spring Tool Suite 4 developer environment.
2. Unzip the ‘CollabSC_REST.zip’ file to retrieve the Java Project files.
3. Open the Package Explorer in Spring Tool Suite and open ‘CollabSC_REST’.
4. Ensure that the data.sql file in ‘CollabSC_REST/src/main/resources/’ is empty, then run the project on the TomCat server with the port 8080.
5. This project uses an H2 local Java SQL database, so a MySQL username and password are not requirements for using this REST API.
6. Open ‘http://localhost:8080/h2-console’ and input “jdbc:h2:mem:Projects” in the ‘JDBC URL’ field. Click ‘Test 
7. Connection’ to test if the REST API is functioning properly.
8. REST calls to ‘http://localhost:8080/’ are now functional, and can be accessed through the HTTP methods POST, GET, and DELETE.


## POST Endpoints

### /login
- *Description*
  -return boolean JSON if user email and password exist in database.
- *Parameters*
  - 'email'
  - 'password'
- *Return Format*
  - 'success' — set to true if the user exists and false is user does not exist
  
### /register
- *Description*
  - Registers a user if the user email is currently not in the database.
- *Parameters*
  - 'fname' - first name
  - 'lname' - last name
  - 'email' - email address
  - 'password'
  - 'classStanding' - current academic year as string
  - 'major'
  - 'phone number' – as string
  - 'resume url'
- *Return Format*
  - 'success' — set to true if the user exists and false is user does not exist

## GET Endpoints

### /users/{id}
- *Description*
  - Returns JSON of User information given a valid user id.
- *Parameters*
  - none
- *Return Format*
   - 'fname' - first name
  - 'lname' - last name
  - 'email' - email address
  - 'password'
  - 'classStanding' - current academic year as string
  - 'major'
  - 'phone number' – as string
  - 'resume url'
- *Error*
  -404 thrown when User does not exist

