package com.indigententerprises.administeredobjectpopulation.configuration;

import jakarta.jms.QueueConnectionFactory;
import jakarta.jms.Queue;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.apache.activemq.artemis.jms.client.ActiveMQQueueConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdministeredObjectConfiguration {

    @Value("${broker.url}")
    private String brokerUrl;

    @Bean
    public QueueConnectionFactory requesterConnectionFactory() {
        final ActiveMQQueueConnectionFactory result = new ActiveMQQueueConnectionFactory(brokerUrl);
        return result;
    }

    @Bean
    public QueueConnectionFactory replierConnectionFactory() {
        final ActiveMQQueueConnectionFactory result = new ActiveMQQueueConnectionFactory(brokerUrl);
        return result;
    }

    @Bean
    public Queue requesterQueue() {
        final String queueName = "requester-queue";
        final ActiveMQQueue result = new ActiveMQQueue(queueName);
        return result;
    }

    @Bean
    public Queue replierQueue() {
        final String queueName = "replier-queue";
        final ActiveMQQueue result = new ActiveMQQueue(queueName);
        return result;
    }
}
