FROM adoptopenjdk/openjdk15
EXPOSE 8070
ARG JAR_FILE=target/google-maps-0.0.1-SNAPSHOT.jar
ADD $JAR_FILE google-maps-app.jar
ENTRYPOINT ["java", "-jar", "/google-maps-app.jar"]