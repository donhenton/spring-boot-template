# NI CDN Server

## Adding Resources

### Method 1
Modify this project, placing resources in the src/main/resources/static folder

### Method 2
Use [webjars] (https://spring.io/blog/2014/01/03/utilizing-webjars-in-spring-boot)
These are jar files configured to serve js,css,image resources.
An example would be https://github.com/donhenton/webjar-app. This uses
a pom entry that points to a privately held jar file.

### Method 3
Pull from public repositories. The pom file contains
```
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>postal.js</artifactId>
    <version>1.0.6</version>
</dependency>
```
and the resource can be accessed at http://[this server host]:31022/webjars/postal.js/1.0.6/postal.js

## Accessing Resources
Items are served up from the static folder. For example d3 would be located
at http://[this server host]:31022/lib/d3/d3.js


#Swagger
http://--server name--:31022/


## spring boot and docker
https://stackoverflow.com/questions/29785587/spring-cant-see-application-properties-inside-a-docker-container

docker can't find the app.properties file in the jar it needs to be broken out into a folder
