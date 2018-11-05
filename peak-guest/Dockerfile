FROM java:8-jre
LABEL author="tuhuayuan@gmail.com"

RUN mkdir /var/peak-guest

ADD ./peak/peak-guest/peak-guest-client/target/*.jar client.jar
ADD ./peak/peak-guest/peak-guest-manage/target/*.jar manage.jar
EXPOSE 8080

# jdk1.8 Avoiding JVM delays caused by random number generation
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar"]