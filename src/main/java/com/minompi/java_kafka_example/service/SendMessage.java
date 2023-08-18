package com.minompi.java_kafka_example.service;

import com.minompi.java_kafka_example.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendMessage {
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String topicName  = "minompi";
    public SendMessage(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void execute(MessageRequest messageRequest) {
        kafkaTemplate.send(topicName, messageRequest.message());
    }
}
