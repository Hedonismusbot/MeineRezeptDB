#JPA / Hibernate

## Maven Dependencies

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
## Konfiguration

application.properties

## parameter - siehe application Properties
* Generic H2 (embedded)
* Generic H2 (embedded)
* org.h2.Driver
* jdbc:h2:mem:testdb
* sa
* password

## Links

* https://www.h2database.com/html/main.html
* http://www.h2database.com/html/grammar.html
* https://www.baeldung.com/spring-boot-h2-database
* https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html

# Feature
* findAll
* findByID
* save
* delete
* set/update done 

# TODO 
* DB austauschen z.b. MySQl