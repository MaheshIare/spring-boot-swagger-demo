# spring-boot-swagger-demo

This is a simple spring application developed using Spring boot to demonstrate the integration of swagger for API documentation. 

## Build


```bash
mvn clean install
```

## Description
I have implemented the spring security with basic username and password based authentication for the Rest API's along with swagger UI access. When you try to access the API's either through Postman or Swagger UI, it prompts for authentication. For simplicity, i have used basic credentials as below 

```java
spring.security.user.name=test
### below password is encoded using BCryptPasswordEncoder and the equivalent value for the same is 'test' ###
spring.security.user.password=$2a$10$udFbwG4rxGIwPNS/hDHMieEnKY9JAaasY7v8bLvP0cj5hWp/oGYf2
```

## More Information
This application has default data loading capability during the startup. By default it loads some data for entities like User. Once the application is up and running, we can simply access below links for swagger UI and API docs. Intentionally excluded the below API's from security for easy access.


[Swagger UI](http://localhost:8080/spring-boot-swagger-demo/swagger-ui/)

[Swagger-Docs](http://localhost:8080/spring-boot-swagger-demo/v2-docs/)

## Instructions
Once you open the Swagger UI link, you should see the option of Authorize API's, clicking on it will prompt for username and password for authentication. You can use above credentials for the same. As soon as, you are authenticated you should be able to access the API's through Swagger UI as well.

## Contributing
Thanks much. Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
Please make sure to update tests as appropriate.
