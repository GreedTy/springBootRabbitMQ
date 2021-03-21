package com.spring.rabbitmq.rabbitcomponent;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {
    public static String EXECHANGE;

    @Value("${QUEUE.EXCHANGE}")
    public void setQueueExchange(String exchange) {
        RabbitMQConfig.EXECHANGE = exchange;
    }

    @Bean
    public Queue queue() {
        return new Queue("TEST",true, false, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXECHANGE, true, false);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return new Binding("TEST", Binding.DestinationType.QUEUE, EXECHANGE, "TEST", null);
    }
}
