FROM openjdk:11
MAINTAINER Rafael Kiyota
COPY /target/case-star-wars-0.0.1-SNAPSHOT.jar /
WORKDIR /
ENTRYPOINT java -jar case-star-wars-0.0.1-SNAPSHOT.jar
EXPOSE 7075