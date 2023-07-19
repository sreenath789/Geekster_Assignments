<h1 align = "center"> Todo-App </h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>


</p>


This project is basic web application Todo-App and performing crud operations.


---
<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Lombok
* Validation
* Swagger

<br>

## Language Used
* Java

---
<br>

## Data Model

The Job data model is defined in the Job class, which has the following attributes:
<br>

* Todo Model
```
    private Integer todoId;
    private String todoName;
    private boolean isTodoDoneStatus;
```
## Bean Factory

The bean factory model is defined in the root directory of src/main/java it is used initialize the object by itself

```
    @Configuration
    public class BeanFactory {
    @Bean
    public List<Todo> getDataSource()
    {
        return new ArrayList<>();
    }
    }
```
<br>

## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.
4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

<br>


## API End Points

The following endpoints are available in the API:

* Todo Controller:
```
POST /todo : create a new todo
GET /todos : get the all todos
GET /todo/done : get the all done todos
GET /todo/undone : get the all undone todos
GET /todo/id : get the todo by id  
PUT todo/{id}/status/{status} : update todo status
DELETE /todo/{id} : delete the todo
```


<br>


## Project Summary

This project is basic web application Todo-App and performing crud operations. 