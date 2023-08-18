package com.minompi.java_kafka_example.controller;

import com.minompi.java_kafka_example.MessageRequest;
import com.minompi.java_kafka_example.service.SendMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    private SendMessage sendMessage;

    public MessageController(SendMessage sendMessage) {
        this.sendMessage = sendMessage;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest) {
        sendMessage.execute(messageRequest);
    }
}
