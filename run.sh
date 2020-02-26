#--detach exits the console, but leaves the instance
#--rm removes the docker instance after exit
#  docker run -e SERVER_PORT=8100  --name=spring-boot-template -p 31000:8100 -d --rm donhenton/spring-boot-template
 mvn clean spring-boot:run  -Dspring-boot.run.mainClass=com.dhenton9000.spring.boot.server.ServerApplication