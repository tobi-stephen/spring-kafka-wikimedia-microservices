package com.laplace.treats.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laplace.treats.model.Treat;
import com.laplace.treats.service.TreatsProducer;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/treats")
@RequiredArgsConstructor
public class TreatsApi {

    private final TreatsProducer treatsProducer;

    @GetMapping
    public ResponseEntity<List<Treat>> addTreats() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping()
    public ResponseEntity<Treat> postMethodName(@RequestBody Treat treat) {

        treatsProducer.addTreats(treat);
        
        return ResponseEntity.ok(treat);
    }
    
}
