# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Web Starter](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-mongodb)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### TO ADD OAuth2 security to any Spring REST API
1. Add a CorsFilter-Why is this needed?
2. Add CustomAccessTokenConverter
3. MethodSecurityConfig- Why is this needed?
4. OAuth2ResourceServerConfigJwt


### TO ADD a new client id
1. insert into Auth server resources/data.sql

2. Add an entry in OAuth2AuthorizationServerConfigJwt.java
.and()
.withClient("reservation-api-client-1")
.secret(passwordEncoder().encode("secret"))
.authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials")
.scopes("reservation", "read", "write")
.accessTokenValiditySeconds(3600) // 1 hour
.refreshTokenValiditySeconds(2592000) // 30 days
3. Add new user name and password for new users in 
WebSecurityConfig.java

# Assignment
1. Figure out why Add a CorsFilter-Why is this needed?
2. Figure out why MethodSecurityConfig- Why is this needed?
3. Add a new client id with read and write access
4 Add a new end user with USER Role
5. Add a new end user with ADMIN role



