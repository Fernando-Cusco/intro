FROM java:openjdk-8-jdk-alpine
ADD /target/apirest-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/apirest-0.0.1-SNAPSHOT.jar"]