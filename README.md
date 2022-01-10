# my_lounge

State: in development

## Introduction

This project will be a social network like Twitter.

- Spring Boot
- Spring Data
- H2/MySQL CE
- Spring Web MVC
- Spring Security
- Freemarker

## Running the Demo Application

The demo module is a small web application.
This application implements registration and authorization of users. Users post various messages with tags. It is possible to search for messages by tags.
Users are endowed with different access rights. Users with the highest access level can edit the data of other users.
All information about users and posts is stored in the database.

### To run the demo application, follow these steps:

#### 1. Clone the Repository
    git clone https://github.com/pav1ov-v/my_lounge.git
    cd my_lounge/
#### 2. Run the demo-jar
    Before running the demo, make sure that the local port 8080 is not in use.
    java -jar ./my_lounge/demo/my_lounge-0.0.1-SNAPSHOT.jar
#### 3. Check the Web-App**
    Open your browser and visit:
    http://localhost:8080/home
    
#### User List only for admin:
#### login: "Vasiliy"; password: "1"
