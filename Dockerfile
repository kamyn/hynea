FROM openjdk:17

WORKDIR /app
COPY /build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

# long build
#FROM gradle:jdk17 as build
#
#WORKDIR /app
#COPY . .
#RUN ./gradlew clean bootJar
#
#FROM gradle:jdk17
## openjdk:17
#WORKDIR /app
#COPY --from=build /app/build/libs/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]