FROM openjdk:11
COPY target/unstore-server.jar unstore-server.jar
ENTRYPOINT ["java","-jar","/unstore-server.jar"]