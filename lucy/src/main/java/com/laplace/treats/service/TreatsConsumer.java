package com.laplace.treats.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.laplace.treats.model.Treat;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class TreatsConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}" )
    public void consumeTreats(ConsumerRecord<String, Treat> record) {
        String key = record.key();
        Treat message = record.value();
        log.info("consuming some treats...");
        log.info("Treats -> " + key + ": " + message);
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}" )
    public void consumeTreats2(ConsumerRecord<String, Treat> record) {
        String key = record.key();
        Treat message = record.value();
        log.info("consuming some treats...");
        log.info("Treats -> " + key + ": " + message);
    }

}
