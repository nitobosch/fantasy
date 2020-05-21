### BUILD image
FROM maven:3-jdk-11 as builder
#Copy Custom Maven settings
#COPY settings.xml /root/.m2/
# create app folder for sources
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
#Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins
#RUN mvn dependency:resolve-plugins
#Copy source code
COPY src /build/src
# Build application
RUN mvn package

FROM openjdk:8-jdk-alpine as runtime
EXPOSE 8180
VOLUME /tmp
COPY --from=builder /build/target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]