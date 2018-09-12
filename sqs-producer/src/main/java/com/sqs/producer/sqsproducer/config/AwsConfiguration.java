package com.sqs.producer.sqsproducer.config;


import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.AwsAsyncClientParams;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfiguration {


    @Bean
    public AmazonSQSAsync amazonSQSAsync(){
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAI66I2VMFE6EUPXRA", "KelYPRysum9LLHJoRLXqyKYKJBQlRETZhcUHJJ++");
        return AmazonSQSAsyncClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder
                    .EndpointConfiguration(
                    "https://sqs.sa-east-1.amazonaws.com/780562472532/sqs-test",
                    "sa-east-1"))
                .withCredentials(new StaticCredentialsProvider(awsCreds))
                .build();
//
////        AmazonSQSAsync amazonSQSAsync =
//        AmazonSQSAsyncClientBuilder amazonSQSAsyncClient = null;
//        amazonSQSAsyncClient.withRegion("sa-east-1");
//        amazonSQSAsyncClient.withEndpointConfiguration(new AwsClientBuilder
//                .EndpointConfiguration(
//                "https://sqs.sa-east-1.amazonaws.com/780562472532/sqs-test",
//                "sa-east-1"));
//        amazonSQSAsyncClient.withCredentials(new StaticCredentialsProvider(awsCreds));
//        //amazonSQSAsyncClient.build();
////                .build().setsetEndpointConfiguration(
////                        new AwsClientBuilder
////                                .EndpointConfiguration(
////                                        "https://sqs.sa-east-1.amazonaws.com/780562472532/sqs-test",
////                                        "sa-east-1")
////                );
//        return amazonSQSAsyncClient.build();
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync);
    }

}
