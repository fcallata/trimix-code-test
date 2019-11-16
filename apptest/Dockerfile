FROM tomcat:8.5-jdk8-openjdk

MAINTAINER Fabio Callata "fcallata@gmail.com"

EXPOSE 8080

RUN rm -rf /usr/local/tomcat/webapps/*

COPY ./target/AppTest.war webapps/apptest.war

CMD ["catalina.sh", "run"]

