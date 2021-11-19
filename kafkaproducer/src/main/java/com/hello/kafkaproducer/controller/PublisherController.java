package com.hello.kafkaproducer.controller;

import com.hello.kafkaproducer.dto.EmpDto;
import com.hello.kafkaproducer.publisher.EmpPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublisherController {

    private final EmpPublisher empPublisher;

    @PostMapping(value = "/emp")
    public ResponseEntity save(@RequestBody EmpDto empDto) {
        empPublisher.publish(empDto);
        return ResponseEntity.ok().build();
    }
}
