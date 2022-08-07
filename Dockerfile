FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE=build/libs/*
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=production","-Duser.timezone=Asia/Seoul","-jar","/app.jar"]
