FROM openjdk:alpine

ENV VIBER_VERSION 0.0.1-SNAPSHOT

RUN mkdir /usr/share/chat
RUN mkdir /usr/share/chat/logs

VOLUME /usr/share/chat/logs

WORKDIR /usr/share/chat/

# set up docker entrypoint script
COPY entrypoint.sh /usr/share/chat/entrypoint.sh
RUN chmod +x /usr/share/chat/entrypoint.sh

COPY build/libs/chat-${VIBER_VERSION}.jar /usr/share/chat/chat.jar

# application port
EXPOSE 8080
# debug port
EXPOSE 5005

ENTRYPOINT ["/usr/share/chat/entrypoint.sh"]