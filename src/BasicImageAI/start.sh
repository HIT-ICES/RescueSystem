#!/bin/bash

python3 ./image_ai/main.py &

sleep 5

java -Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true -jar app.jar
