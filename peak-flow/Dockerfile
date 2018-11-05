FROM java:8-jre
LABEL author="18168875593@163.com"

ADD ./peak/peak-flow/peak-flow-admin/target/*.jar app.jar

EXPOSE 8080

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
  && echo 'Asia/Shanghai' >/etc/timezone

COPY ./peak/peak-flow/peak-flow-admin/simsun.ttc /usr/share/fonts/truetype/dejavu
COPY ./peak/peak-flow/peak-flow-admin/STSONG.TTF /usr/share/fonts/truetype/dejavu

#jdk1.8 Avoiding JVM delays caused by random number generation
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]


