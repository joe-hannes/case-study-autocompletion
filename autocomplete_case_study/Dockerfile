FROM maven:3.8.6-openjdk-18 as build
WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN mvn install -DskipTests

FROM maven:3.8.6-openjdk-18

ENV SERVER_PORT=8080
COPY --from=build /workspace/app/target/autocomplete_case_study-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080
