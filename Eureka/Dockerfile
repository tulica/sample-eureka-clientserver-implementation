FROM openjdk:8-jdk-alpine
WORKDIR target/*.jar
EXPOSE 8760
ADD target/eureka-java.jar eureka-docker.jar
CMD ["java","-jar","eureka-docker.jar"]
