FROM tomcat:9.0.33-jdk11-openjdk-slim

LABEL MAINTAINER="Luqman Setyo N <luqmansen@gmail.com>"


COPY ./conf/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY ./conf/host-manager-context.xml /usr/local/tomcat/webapps/host-manager/META-INF/context.xml
COPY ./conf/manager-context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
COPY ./conf/remap.sh /usr/local/tomcat/bin/remap.sh
COPY ./run.sh /usr/local/tomcat/bin/run.sh

RUN chmod +x /usr/local/tomcat/bin/remap.sh
RUN chmod +x /usr/local/tomcat/bin/run.sh

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]

COPY ./target/ROOT.war /home/webapps/
RUN ln -s /home/webapps/ROOT.war /usr/local/tomcat/webapps/
RUN ln -s /home/webapps/ROOT /usr/local/tomcat/webapps/

CMD ["run.sh"]