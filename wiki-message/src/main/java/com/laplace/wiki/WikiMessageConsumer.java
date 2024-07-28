package com.laplace.wiki;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikiMessageConsumer {

    private final WikiMessageRepository wikiMessageRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}")
    public void consumeWikiMessages(@Payload String message) {
        log.info(message);

        wikiMessageRepository.save(WikiMessage.builder().eventData(message).build());
    }
}
