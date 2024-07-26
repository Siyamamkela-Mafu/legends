package com.siyama.legends.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMqConfig {

    @Value("${legends.rabbit.mq.host}")
    private String host;
    @Value("${legends.rabbit.mq.vhost}")
    private String virtualHost;
    @Value("${legends.rabbit.mq.username}")
    private String username;
    @Value("${legends.rabbit.mq.password}")
    private String password;
    @Value("${legends.rabbit.mq.port}")
    private int port;
    @Value("${legends.email.notification.queue}")
    private String emailQueueName;

    @Bean
    public Queue emailQueue(){
        return new Queue(emailQueueName);
    }
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory(host);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPort(port);
        return connectionFactory;
    }
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
