package com.laplace.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.laplace.handler.WikiMediaChangeHandler;
import com.launchdarkly.eventsource.EventSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikiMediaChangeProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${streams.url}")
    private String streamsUrl;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        log.info("Starting streams event from: " + streamsUrl + ", topic name: " + topicName);
        WikiMediaChangeHandler handler = new WikiMediaChangeHandler(kafkaTemplate, topicName);

        EventSource.Builder builder = new EventSource.Builder(handler, URI.create(streamsUrl));
        builder.build().start();

        TimeUnit.MINUTES.sleep(10);
    }
}
