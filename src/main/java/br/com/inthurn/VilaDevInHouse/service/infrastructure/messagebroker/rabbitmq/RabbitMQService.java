package br.com.inthurn.VilaDevInHouse.service.infrastructure.messagebroker.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    private final AmqpTemplate amqpTemplate;

    public RabbitMQService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(String queueName, Object message){
        amqpTemplate.convertAndSend(queueName, message);
    }

}
