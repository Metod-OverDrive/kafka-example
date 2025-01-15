package com.example.kafkaserver.controller;

import com.example.core.entity.MessageEvent;
import com.example.kafkaserver.service.MessageService;
import com.example.kafkaserver.web.dto.MessageEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rofl")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody MessageEventDto message) {
        try {
            MessageEvent rofl = messageService.sendMessage(message);
            return ResponseEntity.ok(rofl) ;

        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
