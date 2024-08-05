package com.anr.orders.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfiguration {

    private final ApplicationProperties applicationProperties;

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(applicationProperties.orderEventsExchange());
    }

    @Bean
    Queue newOrderQue() {
        return new Queue(applicationProperties.newOrdersQueue());
    }

    @Bean
    Binding newOrderQueueBinding() {
        return BindingBuilder.bind(newOrderQue()).to(directExchange()).with(applicationProperties.newOrdersQueue());
    }

    @Bean
    Queue deliveredQueue() {
        return new Queue(applicationProperties.deliveredOrdersQueue());
    }

    @Bean
    Binding deliveredQueueBinding() {
        return BindingBuilder.bind(deliveredQueue())
                .to(directExchange())
                .with(applicationProperties.deliveredOrdersQueue());
    }

    @Bean
    Queue cancelledQueue() {
        return new Queue(applicationProperties.cancelledOrdersQueue());
    }

    @Bean
    Binding cancelledQueueBinding() {
        return BindingBuilder.bind(deliveredQueue())
                .to(directExchange())
                .with(applicationProperties.cancelledOrdersQueue());
    }

    @Bean
    Queue errorQueue() {
        return new Queue(applicationProperties.errorOrdersQueue());
    }

    @Bean
    Binding errorQueueBinding() {
        return BindingBuilder.bind(errorQueue()).to(directExchange()).with(applicationProperties.errorOrdersQueue());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, ObjectMapper objectMapper) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter(objectMapper));
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
