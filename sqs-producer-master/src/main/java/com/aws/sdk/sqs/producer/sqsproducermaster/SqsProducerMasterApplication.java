package com.aws.sdk.sqs.producer.sqsproducermaster;

import com.aws.sdk.sqs.producer.sqsproducermaster.producer.NotificationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqsProducerMasterApplication implements CommandLineRunner {

    @Autowired
    private NotificationComponent notificationComponent;
    public static void main(String[] args) {
        SpringApplication.run(SqsProducerMasterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        notificationComponent.thumbnailComplete("hellowordl");
    }
}
