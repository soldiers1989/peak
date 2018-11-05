FROM java:8-jre
LABEL author="tuhuayuan@gmail.com"

ADD /peak-resource-provider/target/*.jar app.jar
EXPOSE 8080

# jdk1.8 Avoiding JVM delays caused by random number generation
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]


