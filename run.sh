#--detach exits the console, but leaves the instance
#--rm removes the docker instance after exit
docker run -e SERVER_PORT=8100  --name=spring-boot-template -p 31000:8100 -d --rm donhenton/spring-boot-template