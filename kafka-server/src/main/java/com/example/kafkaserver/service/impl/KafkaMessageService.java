package com.example.kafkaserver.service.impl;

import com.example.core.entity.MessageEvent;
import com.example.kafkaserver.service.MessageService;
import com.example.kafkaserver.web.dto.MessageEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageService implements MessageService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public MessageEvent sendMessage(MessageEventDto messageDto) throws ExecutionException, InterruptedException {
        MessageEvent event = new MessageEvent(
                UUID.randomUUID().toString(),
                messageDto.getTitle(),
                messageDto.getMessage(),
                LocalDateTime.now()
        );

        var record = new ProducerRecord<String, Object>(
                "message-events-topic",
                event.getMessageId(),
                event);

        record.headers().add("messageId", UUID.randomUUID().toString().getBytes());

        SendResult<String, Object> result = kafkaTemplate
                .send(record)
                .get();

        log.info("Partitions: {}", result.getRecordMetadata().partition());
        log.info("Offset: {}", result.getRecordMetadata().offset());

        return event;


    }
}
