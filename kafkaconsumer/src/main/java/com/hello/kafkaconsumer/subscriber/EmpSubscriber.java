package com.hello.kafkaconsumer.subscriber;

import com.hello.kafkaconsumer.dto.EmpDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmpSubscriber {

    @KafkaListener(topics = "${emp.topic.name}", containerFactory = "empDtoConcurrentKafkaListenerContainerFactory")
    public void empListener(EmpDto empDto) {
        log.info("Received Data from Kafka: [{}]", empDto.toString());
    }
}
