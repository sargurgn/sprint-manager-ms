FROM openjdk:8
ADD target/sprint-manager-0.0.1-SNAPSHOT.jar sprint-manager-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "sprint-manager-0.0.1-SNAPSHOT.jar"]