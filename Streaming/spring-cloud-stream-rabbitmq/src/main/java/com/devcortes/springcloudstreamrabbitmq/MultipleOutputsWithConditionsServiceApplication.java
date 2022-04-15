package com.devcortes.springcloudstreamrabbitmq;

import com.devcortes.springcloudstreamrabbitmq.processor.CustomProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootApplication
@EnableBinding(CustomProcessor.class)
public class MultipleOutputsWithConditionsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultipleOutputsWithConditionsServiceApplication.class, args);
    }

    @Autowired
    private CustomProcessor processor;

    @StreamListener(target = CustomProcessor.INPUT, condition = "payload < 10")
    public void routeValuesToAnOutput(Integer val) {
        processor.anOutput()
                .send(message(val));
    }

    @StreamListener(target = CustomProcessor.INPUT, condition = "payload >= 10")
    public void routeValuesToAnotherOutput(Integer val) {
        processor.anotherOutput()
                .send(message(val));
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }
}
