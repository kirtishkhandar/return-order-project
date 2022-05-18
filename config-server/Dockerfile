FROM openjdk:11
LABEL maintainer="kirtishkhandar"
ADD target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT ["java", "-jar", "config-server.jar"]