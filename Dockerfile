FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /usr/app.jar
EXPOSE 8180
ENTRYPOINT ["java","-jar","/usr/app.jar"]