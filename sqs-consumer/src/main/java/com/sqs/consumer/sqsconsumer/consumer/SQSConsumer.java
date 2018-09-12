package com.sqs.consumer.sqsconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.io.IOException;

@Service
public class SQSConsumer {

    private Logger log = LoggerFactory.getLogger(SQSConsumer.class);



    @JmsListener(destination = "sqs-test")
    public void createThumbnail(String requestJSON) throws JMSException {
        log.info("Received ");
        try {
            log.info(requestJSON);
//            ThumbnailRequest request=ThumbnailRequest.fromJSON(requestJSON);
//            String thumbnailUrl=
//                    thumbnailCreator.createThumbnail(request.getImageUrl());
//            notification.thumbnailComplete(new ThumbnailResult(request,thumbnailUrl));
        } catch (Exception ex) {
            log.error("Encountered error while parsing message.",ex);
            throw new JMSException("Encountered error while parsing message.");
        }
    }

}