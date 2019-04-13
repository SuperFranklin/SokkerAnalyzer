FROM openjdk:11
ADD target/SokkerAnalyzer-1.0-SNAPSHOT.jar SokkerAnalyzer-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "SokkerAnalyzer-1.0-SNAPSHOT.jar"]