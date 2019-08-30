#!/bin/sh -x
set -e

if [ -z "$SERVER_PORT" ]; then
  SERVER_PORT=8080
fi

if [ -z "$SPRING_PROFILES_ACTIVE" ]; then
  SPRING_PROFILES_ACTIVE=prod
fi

exec java ${JAVA_OPTS} -jar \
 -Dserver.port=${SERVER_PORT} \
 -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} \
 chat.jar