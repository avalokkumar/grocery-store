#-----------------------------------------------------------------------------------------------------
# Config Server
#-----------------------------------------------------------------------------------------------------
FROM openjdk:8u121-jdk-alpine

MAINTAINER Alok Vishwakarma <avalokkumar@gmail.com>

# Keep consistent with build.gradle 
ENV APP_JAR_NAME basic-config-server
ENV APP_JAR_VERSION 0.0.1
	
RUN mkdir /app

ADD ${APP_JAR_NAME}-${APP_JAR_VERSION}.jar /app/ 
ADD run.sh /app/
RUN chmod +x /app/run.sh 

WORKDIR /app

EXPOSE 8888

ENTRYPOINT ["/bin/bash","-c"]
CMD ["/app/run.sh"]
