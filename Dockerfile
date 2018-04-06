FROM maven AS build

WORKDIR /build

ADD pom.xml .
ADD src ./src

RUN mvn package

FROM openjdk:8-jdk

WORKDIR /app
COPY --from=build /build/target/service1.jar /app

CMD java -jar /app/service1.jar
