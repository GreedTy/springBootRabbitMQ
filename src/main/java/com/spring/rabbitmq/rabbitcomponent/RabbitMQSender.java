package com.spring.rabbitmq.rabbitcomponent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {
    @Autowired
    RabbitTemplate rabbitTemplate;
    Logger logger = LoggerFactory.getLogger(getClass());

    public void sendRabbitMQ(String routingKey, String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXECHANGE, routingKey, message);
        logger.debug("{}-{}",routingKey, message);
    }
}
