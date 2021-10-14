# Spring-MySql-Swaager
Spring Boot + MySql + Swagger

# Environment 
Maven or Gradle
Java 1.8+
MySql 5.7+

# Create Data Base
create database demodb;

# Change Resources
At /src/main/resources/application.properties file, change properties such as username and password.
spring.datasource.username=root
spring.datasource.password=password

# Build
mvn clean package

# Run
java -jar ./target/demoapi-0.0.1-SNAPSHOT.jar

