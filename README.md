# qwebapp

Create Spring Boot application exposing REST-JSON API endpoints which:

a.      return a list of accounts with balances for a given user,

b.      return details for a single account for the user, 

c.      provide ability for editing of account nickname. 

 

Please also provide Swagger documentation.

The code should be production level, with documentation, logging, input validation, exception handling, unit testing, etc.


Instructions:

How to run spring boot ‘qwebapp’ application on Mac:

Clone https://github.com/wootx/qwebapp.git on your local machine
Open console and go to the cloned ‘qwebapp’ directory
Type this - $ ./mvnw clean spring-boot:run
This will start Spring Initializr and start Spring Boot application.


JSON Requests: (Open console and type following commands to query)

1) Query to return a list of accounts with balances for a given user:  curl -v localhost:8080/account/userid?userid=arnie11
2) Query to return details for a single account for the user: curl -v localhost:8080/account/id?id=2
3) Query to provide ability for editing of account nickname: curl -X PUT localhost:8080/account/edit/nickname -H 'Content-type:application/json' -d '{"id": "1","accountNickName": "darth"}'


Note: Please be mindful of the single and double quotes in the Requests.
