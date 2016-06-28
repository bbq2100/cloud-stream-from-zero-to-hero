# Spring Cloud Stream -- From Zero To Hero

Launching the lab exercise "Twitter Streaming"
==============================================
0. Requirements:
    - Docker installation altogether with Docker-Compose (easy way: install Docker toolbox, if both are missing)
    - Gradle installation (tested with version 2.12)
    - Enter Twitter credentials & access token in lab/source/twitter-stream "docker-compose.yml"
1. Start the source (lab/source/twitter-stream): ```docker-compose up```
2. Start the processor (lab/processor/json-2-twitter-message): ```gradle clean bootRun```
3. Start the sink (lab/sink/twitter-message-sink): ```gradle clean bootRun```

Presenting the slides
=====================
- cd slides && python -m SimpleHTTPServer