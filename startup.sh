#!/bin/bash

# Start
echo "Starting up Joey Bot v0.1"

# CUR DIR
cd /home/joey/Desktop/bot/

# REMOVE OLD JARS
rm *.jar

#DOWNLOAD NEW VERSION
wget -O bot.jar http://joeygallegos.com/bot/SkypeBot-1.0-SNAPSHOT-jar-with-dependencies.jar

#RUN BOT
java -jar bot.jar

STATUS=$?

if [ "$STATUS" -eq "0" ]; then

sh startup.sh

fi