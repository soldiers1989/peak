FROM java:8-jre
LABEL author="18168875593@163.com"

ADD ./peak/peak-sys/peak-sys-admin/target/*.jar app.jar
RUN mkdir -p {/tmp/upload/,/tmp/zip/}
EXPOSE 8080

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
  && echo 'Asia/Shanghai' >/etc/timezone


#jdk1.8 Avoiding JVM delays caused by random number generation
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]


