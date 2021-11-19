package com.hello.kafkaproducer.publisher;

import com.hello.kafkaproducer.dto.EmpDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class EmpPublisher {
    @Autowired
    private KafkaTemplate<String, EmpDto> empDtoKafkaTemplate;

    @Value(value = "${emp.topic.name}")
    private String empTopicName;

    public void publish(EmpDto empDto) {
        ListenableFuture<SendResult<String, EmpDto>> future = empDtoKafkaTemplate.send(empTopicName, empDto);

        future.addCallback(new ListenableFutureCallback<SendResult<String, EmpDto>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send Message=[{}] due to:{}", empDto.toString(), ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, EmpDto> result) {
                log.info("Sent Message=[{}] with offset=[{}]", empDto.toString(), result.getRecordMetadata().offset());
            }
        });
    }
}
