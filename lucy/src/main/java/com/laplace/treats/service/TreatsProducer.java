package com.laplace.treats.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.laplace.treats.model.Treat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TreatsProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;    

    final private KafkaTemplate<String, Treat> kafkaTemplate;

    public void addTreats(Treat treat) {
        log.info("add new treats -> " + treat); 
        Message<Treat> value = MessageBuilder
            .withPayload(treat)
            .setHeader(KafkaHeaders.KEY, treat.getId().toString())
            .setHeader(KafkaHeaders.TOPIC, topicName)
            .build();

        kafkaTemplate.send(value);
    }
}
