FROM java:8-jre
LABEL author="tuhuayuan@gmail.com"

ADD ./peak/peak-dd/peak-dd-client/target/*.jar client.jar
ADD ./peak/peak-dd/peak-dd-manage/target/*.jar manage.jar
EXPOSE 8080

# jdk1.8 Avoiding JVM delays caused by random number generation
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar"]


