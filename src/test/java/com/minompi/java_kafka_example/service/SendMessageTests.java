package com.minompi.java_kafka_example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import com.minompi.java_kafka_example.MessageRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

public class SendMessageTests {
    @Mock
    KafkaTemplate<String, String> kafkaTemplate;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void sendMessageCorrectly() {
        MessageRequest messageRequest = new MessageRequest("Foo Bar Baz");
        SendMessage sendMessage = new SendMessage(kafkaTemplate);

        sendMessage.execute(messageRequest);
        Mockito.verify(kafkaTemplate, times(1)).send("minompi", messageRequest.message());
    }

}
