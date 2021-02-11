package com.spring.rabbitmq.rabbitcomponent;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {
    public static String EXECHANGE = "TEST";

}
