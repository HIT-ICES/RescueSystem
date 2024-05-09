FROM ubuntu:focal
MAINTAINER Xiang

RUN apt-get update \
    && apt-get install -y openjdk-8-jre tesseract-ocr tesseract-ocr-eng tesseract-ocr-chi-sim tesseract-ocr-chi-tra

ENV TESSDATA_PREFIX=/usr/share/tesseract-ocr/4.00/tessdata/

ADD target/BasicOCR-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Djava.net.preferIPv4Stack=true", "-jar","app.jar"]
