#!/usr/bin/env bash

docker run -p 49001:8080 -v ~/docker_volumes/jenkins:/var/jenkins_home:z -t jenkins