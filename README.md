# Compilar los proyectos
cd microservicio-cliente
mvn clean package -DskipTests
cd ..

cd microservicio-cuenta
mvn clean package -DskipTests
cd ..

# Levantar los contenedores
docker-compose up --build
