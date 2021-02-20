FROM java:openjdk-8-jdk-alpine
ADD /target/d-cash.jar //
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/d-cash.jar"]