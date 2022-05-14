
FROM maven:3.6.3-jdk-11-openj9 as builder

WORKDIR /app
COPY pom.xml .
RUN mvn clean

COPY src ./src
RUN mvn package -Dmaven.test.skip

FROM adoptopenjdk/openjdk11

COPY --from=builder /app/target/mymobileworkerAPI*.jar /mymobileworkerAPI.jar

ENTRYPOINT ["java","-jar","mymobileworkerAPI.jar"]
  ## Run the web service on container startup.
CMD ["java","-Dcom.sun.net.ssl.checkRevocation=false","-Dserver.port=8000","-jar","mymobileworkerAPI.jar"]

ARG JAR_FILE=target/*.jar
