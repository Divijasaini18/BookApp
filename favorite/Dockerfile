FROM java:8-jre
# FROM openjdk:11-jre-slim
WORKDIR /usr/src

ADD ./target/bookApp-0.0.1-SNAPSHOT.jar /usr/src/Favorite
#EXPOSE 8001
ENTRYPOINT ["java","-jar","/usr/src/Favorite"]
