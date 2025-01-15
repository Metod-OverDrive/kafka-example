package com.example.kafkaserver.service;

import com.example.core.entity.MessageEvent;
import com.example.kafkaserver.web.dto.MessageEventDto;

import java.util.concurrent.ExecutionException;

public interface MessageService {

    MessageEvent sendMessage(MessageEventDto message) throws ExecutionException, InterruptedException;
}
