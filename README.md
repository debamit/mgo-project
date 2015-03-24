MGO Project 

Technologies

Java 1.8
Mongo 2.6.4


Libraries used:

Spring Boot : for scaffolding web application 
Spring MVC and Core :  for handling REST calls and providing Dependency Injection 
Spring Date : for connection to Mongo db and providing interface for CRUD operations
Mockito : for unit testing

Running Locally 

Clone repo git clone https://github.com/debamit/mgo-project.git
If maven installed : mvn clean spring-boot:run
Else: Run main method as Java Application under MgoProjectApplication

Versioning

Versioning can he handles either by having version number in the uri itself like 

 @RequestMapping(value = "/api/user/v1", method = GET)

 @RequestMapping(value = "/api/user/v2", method = GET)


Or the other strategy would be to have the version number in the header 

@RequestMapping(
value = "/api/user/v1", method = GET, headers = "X-API-Version=v1")

@RequestMapping(
value = "/api/user/v1", method = GET, headers = "X-API-Version=v2")

Both strategies have their pros and cons.


Endpoint Definitions

Get all Users
http://localhost:8080/api/user

Filter User
http://localhost:8080/api/user/filter?city=Los Ageles

Login User
http://localhost:8080/login
user name : user
password : password


Mongo Status
http://localhost:8080/status

list of files
http://localhost:8080/files/path/?dirPath=/Users

