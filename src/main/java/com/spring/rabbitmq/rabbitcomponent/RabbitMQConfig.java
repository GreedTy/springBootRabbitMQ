package com.spring.rabbitmq.rabbitcomponent;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {
    public static String EXECHANGE = "TEST";

    @Bean
    public Queue queue() {
        return new Queue("test",false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXECHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("test");
    }
}
