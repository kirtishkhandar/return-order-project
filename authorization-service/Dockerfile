FROM openjdk:11
LABEL maintainer="kirtishkhandar"
ADD target/authorization-service-0.0.1-SNAPSHOT.jar authorization-service.jar
ENTRYPOINT ["java", "-jar", "authorization-service.jar"]