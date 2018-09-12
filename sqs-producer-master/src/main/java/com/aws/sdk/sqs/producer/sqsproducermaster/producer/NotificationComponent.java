package com.aws.sdk.sqs.producer.sqsproducermaster.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NotificationComponent {

    @Autowired
    protected JmsTemplate defaultJmsTemplate;

    public void thumbnailComplete(String result) throws IOException {
        defaultJmsTemplate.convertAndSend("sqs-test",
                result);
    }

}