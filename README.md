# sample-eureka-clientserver-implementation
Simple Eureka Server-Client Implementation.
This application implements 2 applications - 'client' and 'com.webapi', alongside a Eureka Server. 
Furthermore, consists of a dockercompose.yml file for containerisation of the application.

  1. Install docker and postgres SQL on your local system.
  2. Navigate to the classpath of project stored locally.
  3. Run command 'docker-compose up'

The docker daemon should run 4 containers simultaneously consisting of 'postgres', 'client', 'ums-resources', and 'eureka-server'.
To check for successful implementation-
  1. pgAdmin should connect to docker
  2. eureka server should enlist both applications
