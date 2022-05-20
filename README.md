# Bank service application

### Installation way 1

1. Please run this command which pull the  rabbit mq image from docker hub

` docker run -d --name my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management`

2. Please run this command which is pull the postgres image from docker hub

`docker run --rm -it -p 5432:5432 -e POSTGRES_PASSWORD=1234 -e POSTGRES_USER=postgres -e POSTGRES_DB=InitialDB postgres`

3. Clone the application through github link here

https://github.com/pooyafils/spring-5-crud-application-java-configuration.git

4. Now you have both postgres and rabbitmq up and running on your machine please type this address on your browser to access to rabbitmq admin page username and password is guest and create  queues as following bankQueue ,currencyQueue transactionQueue

http://localhost:15672/

5. Now open the pg admin and create database named bankservicedb . If you look at the source code you see the sql file named  AppInsertData.sql open it and run the script for creating tables  and then also insert the data that is inside the file.
6. Now open the application by intellij idea and run it.

### Installation way 2
1. .Clone the application through github link here
   
   https://github.com/pooyafils/spring-5-crud-application-java-configuration.git
   
2. run docker file located on source folder and after that  go to the folder named my docker and run the **docker-compose.yml** by `docker compose up` .please make sure the rabbitmq and postgres ports are not busy

