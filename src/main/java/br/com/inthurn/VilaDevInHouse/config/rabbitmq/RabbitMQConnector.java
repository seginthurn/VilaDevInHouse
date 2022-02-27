package br.com.inthurn.VilaDevInHouse.config.rabbitmq;

import br.com.inthurn.VilaDevInHouse.config.rabbitmq.binding.BindingManager;
import br.com.inthurn.VilaDevInHouse.config.rabbitmq.exchange.ExchangeManager;
import br.com.inthurn.VilaDevInHouse.config.rabbitmq.queue.QueueManager;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class RabbitMQConnector {

    private AmqpAdmin amqpAdmin;

    public RabbitMQConnector(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    public void connect(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 300);

        BindingManager villageReport = new BindingManager(QueueManager.create("village.report"), ExchangeManager.create("vila.exchange"), args);

        amqpAdmin.declareQueue(villageReport.getQueue());

        amqpAdmin.declareExchange(villageReport.getDirectExchange());

        amqpAdmin.declareBinding(villageReport.create());
    }


}
