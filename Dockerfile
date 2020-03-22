FROM tomcat:alpine

RUN ["rm", "-rf", "/usr/local/tomcat/webapps/ROOT.war"]
COPY target/ugly-jsf.war /usr/local/tomcat/webapps/ROOT.war