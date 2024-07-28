package com.laplace;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.laplace.service.WikiMediaChangeProducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class WikiMediaClr implements CommandLineRunner{

    private final WikiMediaChangeProducer producer;

    @Override
    public void run(String... args) throws Exception {
        log.info("STARTING CLR...");
        producer.sendMessage();
    }
    
}
