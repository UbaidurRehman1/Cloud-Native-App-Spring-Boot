cd netflix-eureka-naming-server || exit
#mvn clean spring-boot:build-image
#docker tag netflix-eureka-naming-server:0.0.1-SNAPSHOT ubaidurehman/netflix-eureka-naming-server:latest
cd .. || exit
cd netflix-zuul-api-gateway-server || exit
mvn clean spring-boot:build-image
docker tag netflix-zuul-api-gateway-server:0.0.1-SNAPSHOT ubaidurehman/netflix-zuul-api-gateway-server:latest
cd .. || exit
