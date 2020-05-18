FROM openjdk:8-jdk-alpine
WORKDIR target/*.jar
EXPOSE 8088
ENV SPRING_DATASOURCE_URL jdbc:postgresql://172.17.0.4:5432/postgres
ENV EUREKA_CLIENT_SERVICE-URL_DEFAULTZONE http://172.17.0.3:8761/eureka
ADD target/ums-java.jar ums-docker.jar
CMD ["java","-jar","ums-docker.jar"]
