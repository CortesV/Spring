package com.devcortes.springcloudstreamrabbitmq;

import com.devcortes.springcloudstreamrabbitmq.model.LogMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringCloudStreamApplication.class)
@DirtiesContext
public class CustomLoggerApplicationTests {

    @Autowired
    private Processor pipe;

    @Autowired
    private MessageCollector messageCollector;

    @Test
    public void whenSendMessage_thenResponseShouldUpdateText() {
        pipe.input()
                .send(MessageBuilder.withPayload(new LogMessage("This is my message"))
                        .build());

        Object payload = messageCollector.forChannel(pipe.output())
                .poll()
                .getPayload();

        assertEquals("{\"message\":\"[1]: This is my message\"}", payload.toString());
    }
}
