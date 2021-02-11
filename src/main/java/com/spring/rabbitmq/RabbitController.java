package com.spring.rabbitmq;

import com.spring.rabbitmq.rabbitcomponent.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    @Autowired
    public RabbitMQSender rabbitMQSender;

    @PostMapping("/message")
    public void sender() {
        rabbitMQSender.sendRabbitMQ("test", "test");
    }
}
