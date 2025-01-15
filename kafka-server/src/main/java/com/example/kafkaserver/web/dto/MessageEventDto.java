package com.example.kafkaserver.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageEventDto {

    private String title;
    private String message;

}
