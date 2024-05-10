FROM septemberhx/imageai-java:v1.2
MAINTAINER Xiang
WORKDIR /app
ADD target/BasicImageAI-1.0-SNAPSHOT.jar app.jar
ADD image_ai image_ai
ADD start.sh start.sh
RUN chmod a+x start.sh
EXPOSE 8080
ENTRYPOINT ["./start.sh"]
