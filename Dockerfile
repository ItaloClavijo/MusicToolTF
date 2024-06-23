FROM amazoncorretto:17-alpine-jdk
MAINTAINER ItaloClavijo
COPY target/MusicToolTF-0.0.1-SNAPSHOT MusicToolBackend.jar
ENTRYPOINT ["java", "-jar","/MusicToolBackend.jar"]