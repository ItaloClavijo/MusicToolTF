FROM amazoncorretto:17-alpine-jdk
MAINTAINER ItaloClavijo
COPY target/MusicToolTF-0.0.1-SNAPSHOT.jar MusicToolBackend.jar
ENTRYPOINT ["java", "-jar","/MusicToolBackend.jar"]
