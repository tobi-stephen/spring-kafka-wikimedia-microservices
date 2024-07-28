package com.laplace.wiki;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/wiki-messages")
public class WikiMessageApi {
    
    private final WikiMessageRepository wikiMessageRepository;

    @GetMapping
    public ResponseEntity<List<WikiMessage>> getMethodName(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size ) {
        
        log.info("Get page: " + page + ", size: " + size);
        List<WikiMessage> result = wikiMessageRepository.findAll(PageRequest.of(page, size)).toList();

        return ResponseEntity.ok(result);
    }
    
}
