package com.laplace.handler;

import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class WikiMediaChangeHandler implements EventHandler{

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String topicName;

    @Override
    public void onClosed() throws Exception {
        log.info("stream closed");
    }

    @Override
    public void onComment(String arg0) throws Exception {
        log.info(arg0);
    }

    @Override
    public void onError(Throwable arg0) {
        log.info(arg0.getMessage());
    }

    @Override
    public void onMessage(String arg0, MessageEvent arg1) throws Exception {
        log.info("arg0: " + arg0 + ", arg1: " + arg1);
        
        kafkaTemplate.send(topicName, arg1.getData());
    }

    @Override
    public void onOpen() throws Exception {
        log.info("stream opened");
    }
    
}
