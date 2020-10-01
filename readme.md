Abstract
========
- Cloud Native App represent basic reference for different stacks such as
    - micro-service architecture 
    - gateway server
    - naming server
    - aop
    - logging
    - distributed tracing with zipkin
    - containerization
    - swagger implementation
- My aim is to remain up to date with each stack such as Java 15, Spring Boot 2.3.4 and Spring Cloud HOXTON SR8

Note
---
For now: It only converts USD to PKR as there is only one entry in a database.
I will populate a database with all available exchange rates each 15 minutes using another micro-service.

About
----
- Cloud Native App which convert currency from given country code to targeted country code. 
- Currency Conversion Rest API  is actual responsible to interact with micro-services using ```api-gateway-server```. 
- An Actor (React Client, Angular Client etc ) can  send a request to rest-api, it interacts with *CURRENCY-EXCHANGE-SERVICE*  micro-service to get exchange rate and then *CURRENCY-CONVERSION-SERVICE* micro-service to convert this currency
- ![Micro Service Architecture](resource/micro-service-architecture.png)
- In above diagram [You Can Access it here: Pre-Req: Run the App First](http://localhost:9411/zipkin/), We have 
    - Two micro-services in which ```currency-exchange-service```  and ```currency-conversion-service``` helps us to convert currency from one country code to another country code.
    - One api-gateway-server
    - One rest-api which expose their URLs to Clients

Requirements
-----------
- [Maven 3.6.3 or later](./resource/install-require-softwares.md)
- [Docker 19.03.8 or later](./resource/install-require-softwares.md)
- [JDK 15 or later](./resource/install-require-softwares.md)
- [Set JAVA_HOME](./resource/install-require-softwares.md)

How to Run
----------
-   ``` git clone https://github.com/UbaidurRehman1/SpringServices_Rest_Micro```
-   ``` cd SpringServices_Rest_Micro ```
-   ```mvn clean install -DskipTests```
-   ```cd envcn```
-   ```./run.sh``` (it will run all tools which our services needs such as naming server, db, zipkin etc)
-   ``` cd ..``` 
-   ``` ./run.sh ``` 

How it works
------------
- Simply go to Swagger UI and interact with different end points.

Swagger UI
----------
- [Go here to check API docs about Currency Conversion API](http://localhost:5200/swagger-ui.html#/exchange-controller)

Naming Server
-------------
- [Go Here to see All Micro-Services associated to this Cloud Native App](http://localhost:8761)

Zipkin Server
------------
- [Go Here to trace the micro-services](http://localhost:9411/zipkin/)

REST API
--------
-   [Currency Conversion API](http://localhost:5200/actuator/health)

Micro-Services
--------------
-   [CURRENCY-EXCHANGE-SERVICE](http://localhost:8000/actuator/health)
-   [CURRENCY-CONVERSION-SERVICE](http://localhost:8100/actuator/health)

Servers
-------
-   [NETFLIX-ZUUL-API-GATEWAY-SERVER](http://localhost:8755/actuator/health)
-   [NETFLIX-EUREKA-NAMING-SERVER](http://localhost:8761/)
-   [CONFIG-SERVER](http://localhost:8888/actuator/health)
-   [ZIPKIN SERVER](http://localhost:9411/zipkin/)
-   [RABBIT MQ SERVER *Username & Password: guest*](http://localhost:15672/)

Config Repo
-----------
- [Public Config Repo](https://github.com/UbaidurRehman1/public-repo)

Note
----
- You can read about each micro-service by going inside each folder
- [To get More info about this repo](./moreinfo.md)