FROM tomcat:9.0.33-jdk11-openjdk-slim

COPY ./conf/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY ./conf/host-manager-context.xml /usr/local/tomcat/webapps/host-manager/META-INF/context.xml
COPY ./conf/manager-context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY ./target/ugly-jsf.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]