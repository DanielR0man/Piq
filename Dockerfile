FROM amazoncorretto:11-alpine-jdk AS build
RUN apk add --no-cache maven
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM amazoncorretto:11-alpine-jdk
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]