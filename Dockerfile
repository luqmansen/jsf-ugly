FROM tomcat:9.0.33-jdk11-openjdk-slim

MAINTAINER Luqman Setyo N <luqmansen@gmail.com>

COPY ./conf/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY ./conf/host-manager-context.xml /usr/local/tomcat/webapps/host-manager/META-INF/context.xml
COPY ./conf/manager-context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
# COPY ./conf/serverPort.xml /usr/local/tomcat/conf/serverPort.xml


RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY ./target/ugly-jsf.war /usr/local/tomcat/webapps/ROOT.war

RUN sed -i -e 's/8080/'"$PORT"'/g' /usr/local/tomcat/conf/server.xml
# RUN ["mv", "/usr/local/tomcat/conf/serverPort.xml", "/tmp/srv.xml"]

CMD ["catalina.sh", "run"]