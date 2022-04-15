package com.devcortes.springcloudstreamrabbitmq;

import com.devcortes.springcloudstreamrabbitmq.processor.CustomProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(CustomProcessor.class)
public class MultipleOutputsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultipleOutputsServiceApplication.class, args);
    }

    @Autowired
    private CustomProcessor processor;

    @StreamListener(CustomProcessor.INPUT)
    public void routeValues(Integer val) {
        if (val < 10) {
            processor.anOutput()
                    .send(message(val));
        } else {
            processor.anotherOutput()
                    .send(message(val));
        }
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }
}
