#!/usr/bin/env bash

sed -i -e 's/8080/'"$PORT"'/g' /usr/local/tomcat/conf/server.xml
