cd ./netflix-eureka-naming-server
mvn clean package -DskipTests
cd ..
docker-compose up --build