# Spring Boot with PostgreSQL & Docker

## Overview
This project is a Spring Boot application that uses PostgreSQL as its database. The application and database are containerized using Docker and managed via Docker Compose. The containers share the same network and use a volume for persistent database storage.

## Features
- Spring Boot backend
- PostgreSQL database
- Docker Compose for easy setup
- Shared network and volume management
- `.dockerignore` file to optimize builds

## Prerequisites
Ensure you have the following installed:
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

## Setup Instructions
### 1. Clone the Repository
```sh
git clone https://github.com/kyawyea92/springboot_postgres_docker.git
cd springboot_postgres_docker
```

### 2. Configure Environment Variables
Create a `.env` file in the root directory with the following variables:
```env
POSTGRES_USER=root
POSTGRES_PASSWORD=password
POSTGRES_DB=dockerVersion
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/dockerVersion
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=password
```

### 3. Build the Application
```sh
mvn clean package
```

### 4. Run with Docker Compose
```sh
docker-compose up --build -d
```

### 5. Verify Running Containers
```sh
docker ps
```

## Docker Compose Configuration
The `docker-compose.yml` file defines two services:
- `app`: The Spring Boot application
- `db`: The PostgreSQL database

Example `docker-compose.yml` file:
```yaml
version: '3.8'
services:
  db:
    image: postgres:latest
    container_name: postgres_container
    restart: always
    environment:
      POSTGRES_USER: ${POSTGRES_USER}
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
      POSTGRES_DB: ${POSTGRES_DB}
    ports:
      - "5432:5432"
    networks:
      - backend
    volumes:
      - ./postgres_data:/var/lib/postgresql/data
  
  app:
    build: .
    container_name: springboot_app
    restart: always
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: ${SPRING_DATASOURCE_URL}
      SPRING_DATASOURCE_USERNAME: ${SPRING_DATASOURCE_USERNAME}
      SPRING_DATASOURCE_PASSWORD: ${SPRING_DATASOURCE_PASSWORD}
    ports:
      - "8080:8080"
    networks:
      - backend

networks:
  backend:
    driver: bridge

volumes:
  postgres_data:
    driver: local
```

## `.dockerignore` File
To optimize the build, a `.dockerignore` file is included:
```
target/
*.jar
*.war
*.class
*.log
.idea/
*.iml
.DS_Store
node_modules/
.env
```

## Stopping and Removing Containers
To stop and remove the containers, run:
```sh
docker-compose down -v
```

## Accessing the Database
You can connect to the PostgreSQL database using:
```sh
docker exec -it postgres_container psql -U admin -d mydatabase
```

## Logs & Debugging
View logs for the application:
```sh
docker logs -f springboot_app
```

View logs for the database:
```sh
docker logs -f postgres_container
```

## Conclusion
This setup provides a robust way to develop and run a Spring Boot application with PostgreSQL using Docker. Happy coding! 🚀

