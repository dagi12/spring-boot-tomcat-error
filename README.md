# spring-boot-tomcat-error

## Description
When deploying as a WAR application on Spring Boot 2 all errors from  uses container error page instead of Spring error handler.

 #### Notes
- everything is fine when you using spring 1.5
- also everything is fine with Spring Boot 2 but only if you use embedded container 

## Steps to reproduce

1. 
    Clone sample project 
    ```bash
    git clone https://github.com/dagi12/spring-boot-tomcat-error.git
    ```
2. 
    Build and deploy
    ```bash 
    ./gradlew clean build
    #deploy to tomcat server
    ```
    
   The output is 
   ```html
    <!doctype html>
    <html lang="en">
    <head><title>HTTP Status 500 – Internal Server Error</title</head>
    <body><h1>HTTP Status 500 – Internal Server Error</h1>
    <hr class="line"/>
    <p><b>Type</b> Status Report</p>
    <p><b>Message</b> test exception</p>
    <p><b>Description</b> The server encountered an unexpected condition that prevented it from fulfilling the request.</p>
    <hr class="line"/>
    <h3>Apache Tomcat/8.5.28</h3></body>
    </html>
    ```
    Which is container error page
 
3. If you do the same with embedded container. The output is   
   ```bash
   ./gradlew bootRun
   ```
    ```json
    {
        "timestamp": "2018-04-10T09:42:09.875+0000",
        "status": 500,
        "error": "Internal Server Error",
        "message": "test exception",
        "path": "/test"
    }
    ```
    
    Which is excepted. Valid error output is also provided using Spring 1.5 with both deployment methods. 
    ```bash
    git checkout origin spring-1.5
    ```  