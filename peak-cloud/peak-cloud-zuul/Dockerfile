FROM java:8-jre
LABEL author="masspick"

ADD ./peak/peak-cloud/peak-cloud-zuul/target/*.jar app.jar

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# jdk1.8 Avoiding JVM delays caused by random number generation
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
