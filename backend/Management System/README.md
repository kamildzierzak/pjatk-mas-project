# Management System

### Packages

* config - contains configuration classes for Spring Boot application
* controllers - controller classes, which handle incoming HTTP requests and return responses
* domain (model) - holds the core domain objects of application, representing the main business entities and logic
    * dto - simple objects used to transfer data between different parts of the application, especially between the
      client and server
    * entities - the JPA entities that map to database tables. They are annotated with @Entity and typically contain
      fields, getters/setters, and possibly relationships between other entities (e.g., @OneToMany, @ManyToOne)
* mappers - responsible for mapping data between different layers of the application
* repositories - contains repository interfaces that extend Spring Data JPA repositories. These interfaces are used to
  perform CRUD operations on entities
* services - includes service classes, which contain the business logic of application. Service classes interact with
  repositories to fetch, process, and save data.

### Notes

* [Lombok features](https://projectlombok.org/features/)
* [Model Mapper](https://modelmapper.org/)
* [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)
* [Guide To Running Logic on Startup in Spring](https://www.baeldung.com/running-setup-logic-on-startup-in-spring)
* [Inheritance vs. Composition in JPA](https://www.baeldung.com/jpa-inheritance-vs-composition)
* [Difference Between @JoinColumn and mappedBy](https://www.baeldung.com/jpa-joincolumn-vs-mappedby)
* [Why Is Field Injection Not Recommended?](https://www.baeldung.com/java-spring-field-injection-cons)
* [Pagination and Sorting using Spring Data JPA](https://www.baeldung.com/spring-data-jpa-pagination-sorting)
* [Composition vs. Inheritance with JPA and Hibernate](https://thorben-janssen.com/composition-vs-inheritance-jpa-hibernate/#using-composition-with-jpa-and-hibernate)
* [Map Associations with JPA and Hibernate – The Ultimate Guide](https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/#manyToOne)
* [Mapping Collections with Hibernate and JPA](https://thorben-janssen.com/collections-hibernate-jpa/)
* [How to map an association as a java.util.Map](https://thorben-janssen.com/map-association-java-util-map/)
* [API Design Guide](https://cloud.google.com/apis/design)

---

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#web.security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
