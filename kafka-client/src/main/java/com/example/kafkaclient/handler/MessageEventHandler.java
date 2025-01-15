package com.example.kafkaclient.handler;

import com.example.core.entity.MessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageEventHandler {

    @KafkaListener(topics = "message-events-topic", groupId = "message-events-listeners")
    public void handle(@Payload MessageEvent event,
                       @Header("messageId") String messageId) {
        log.info("Message Id = {}. Message = {}", messageId, event.toString());

    }

}
