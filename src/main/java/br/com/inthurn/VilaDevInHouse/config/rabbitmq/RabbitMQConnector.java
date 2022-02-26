package br.com.inthurn.VilaDevInHouse.config.rabbitmq;

import br.com.inthurn.VilaDevInHouse.config.rabbitmq.binding.BindingManager;
import br.com.inthurn.VilaDevInHouse.config.rabbitmq.exchange.ExchangeManager;
import br.com.inthurn.VilaDevInHouse.config.rabbitmq.queue.QueueManager;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnector {

    private AmqpAdmin amqpAdmin;

    public RabbitMQConnector(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    public void connect(){
        BindingManager villageReport = new BindingManager(QueueManager.create("village.report"), ExchangeManager.create("vila.exchange"));
        BindingManager villageServices = new BindingManager(QueueManager.create("village.services"), ExchangeManager.create("vila.exchange"));

        amqpAdmin.declareQueue(villageReport.getQueue());
        amqpAdmin.declareQueue(villageServices.getQueue());

        amqpAdmin.declareExchange(villageReport.getDirectExchange());

        amqpAdmin.declareBinding(villageReport.create());
        amqpAdmin.declareBinding(villageServices.create());

    }


}
