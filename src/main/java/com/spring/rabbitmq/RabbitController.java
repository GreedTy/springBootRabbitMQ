package com.spring.rabbitmq;

import com.spring.rabbitmq.rabbitcomponent.RabbitMQSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public RabbitMQSender rabbitMQSender;

    @PostMapping("/message")
    public void sender() {
        logger.debug("test123");
        rabbitMQSender.sendRabbitMQ("test", "test");
    }
}
