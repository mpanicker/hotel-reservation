# Getting Started

### Reference Documentation
### to run MongoDB(on Mac)
1. make sure /data/db exists
2. sudo mongod


### TO ADD OAuth2 security to any Spring REST API
1. git clone the project at  https://github.com/Baeldung/spring-security-oauth
2. run oauth-authorization-server - the Authorization Server (port = 8081)
3. to get a auth token
POST http://localhost:8081/spring-security-oauth-server/oauth/token?username=john&password=123&grant_type=password&client_id=reservation-api-read-client
Authorization
Basic Auth
Username:reservation-api-read-client
Password:secret 
4. Use the above token as a Bearer token while invoking reservation api
5. Run angularjs/oauth-ui-password (port = 8084) to get token using a UI


#### TO ADD a new client id
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

# To build and run using Docker
1. ./mvnw install dockerfile:build

2. docker run -p 8080:8080 -t hotel-reservation/hotel-reservation:latest



#API Endpoint
1. GET localhost:8080/api/v1/reservation/4wBcXGrQ

2. GET localhost:8080/api/v1/reservation?email=m_panicker@yahoo.com

3. localhost:8080/api/v1/reservation?email=joe@techprotech.com

4. 




