FROM java:8-jre
LABEL author="tuhuayuan@gmail.com"

ADD ./peak-cloud/peak-cloud-zuul/target/*.jar zuul.jar
ADD ./peak-cloud/peak-cloud-jwt/target/*.jar jwt.jar


# jdk1.8 Avoiding JVM delays caused by random number generation
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar",/app.jar]
EXPOSE 8080

