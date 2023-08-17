package com.minompi.java_kafka_example.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "minompi", groupId = "foo")
    public void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
