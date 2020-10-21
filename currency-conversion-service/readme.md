Dependencies
============

- #### Web (embedded tomcat + MVC)
    - spring-boot-starter-web
- #### Dev Tools
    - spring-boot-devtools
    - lombok
    - spring-boot-configuration-processor
- #### Dev Ops
    - spring-boot-starter-actuator
- #### Cloud
    - ##### spring-cloud-starter-netflix-eureka-client
    - ##### spring-cloud-starter-zipkin
- #### AOP
    - spring-boot-starter-aop
- #### Cache
    - caffeine
- #### Test
    - spring-boot-starter-test

[Distributed Tracing](./../moreinfo.md#distributed-tracing)
-----------------------------------------------------------

Notes
-----
- For deserialization of POJO, we can use @JsonAlias for different names of a field
