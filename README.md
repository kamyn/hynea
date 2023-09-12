## HYNEA

------

The simple CRUD web service of restraunt menu on Spring.

In the main page visitor can see menu items and ingredients
they contain. Also, user with administrator privilege can
add, remove and update menu items in the `/menu-panel` page.


### Requirements

 - `java 17`
 - `docker` and `docker compose`

### Deploy

 - Build project from source: `./gradlew clean bootJar`
 - Build docker image: `docker build -t hynea-test .`
 - Run docker compose file: `docker compose up`

 The site will available at `localhost:8080`

### Project stack

 - java 17
 - SpringBoot
 - PostgreSQL
 - Spring Security
 - Thymeleaf
 - Flyway
 - JUnit and Mockito