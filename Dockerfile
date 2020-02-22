
FROM maven:3.5-jdk-8
 
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package


FROM ibmcom/websphere-liberty:kernel-java8-ibmjava-ubi

COPY liberty/server.xml /config/

COPY --from=0 /usr/src/app/target/todoapp.war /config/dropins/

USER root:0
RUN chown -vR 1001:0 /config/*

USER 1001:0
# This script will add the requested XML snippets, grow image to be fit-for-purpose and apply interim fixes
# https://github.com/WASdev/ci.docker

ARG VERBOSE=true
RUN configure.sh

EXPOSE 9080 9443