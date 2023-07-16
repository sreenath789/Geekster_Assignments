<h1 align = "center"> MAPPING-PRACTICE </h1>

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

<a >
    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-blue.svg">
</a>
</p>

This project is about mapping practice @onetone,@onetomany,@manytoone.@manytomany and perform crud opertions


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
* Spring Data JPA
* MySQL Driver
* Lombok
* Validation
* Swagger

<br>

## Database Configuration
To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/<DatabaseName>
spring.datasource.username = <userName>
spring.datasource.password = <password>
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```
<br>

## Language Used
* Java

---
<br>

## Data Model

The Job data model is defined in the Job class, which has the following attributes:
<br>

* Student Model
```
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;
    @OneToOne
    private Address address;
```

* Address Model
```
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;

```

* Book Model
```
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String title;
    private String author;
    private String description;
    private String price;
    @ManyToOne
    private Student student;
```
* Course Model
```
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String title;
    private String description;
    private String duration;
    @ManyToMany
    @JoinTable(name="student_courses",joinColumns = @JoinColumn(name = "fk_course-id"),inverseJoinColumns = @JoinColumn(name = "fk_student_id"))
    List<Student> studentList;
```

* Laptop Model
```
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer laptopId;
    private String name;
    private String brand;
    private Integer price;
    @OneToOne
    private Student student;
```
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

* Student Controller:
```
POST /student : create a new student
GET /students : get the all students 
PUT student/{id}/dept/{department} : update student department
DELETE /student/{id} : delete the student
```

* Address Controller:
```
POST /address : create a new Address
GET /Addresses : get the all Addresses 
PUT Address/{id}/state/{state} : update Address state
DELETE /Address/{id} : delete the Address
```

* Book Controller:
```
POST /Book : create a new Book
GET /Books : get the all Books 
PUT Book/{id}/price/{title} : update Book price
DELETE /Book/{id} : delete the Book
```
* Course Controller:
```
POST /Course : create a new Course
GET /Courses : get the all Courses 
PUT Course/{id}/title/{title} : update Course title
DELETE /Course/{id} : delete the Course
```

* Laptop Controller:
```
POST /laptop : create a new laptop
GET /laptops : get the all laptops 
PUT laptop/{id}/brand/{brand} : update laptop brand
DELETE /laptop/{id} : delete the laptop
```


<br>

## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

## Project Summary

This project is about mapping practice @onetone,@onetomany,@manytoone.@manytomany and perform crud opertions
