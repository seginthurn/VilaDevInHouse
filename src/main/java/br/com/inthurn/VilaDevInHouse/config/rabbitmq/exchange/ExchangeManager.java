package br.com.inthurn.VilaDevInHouse.config.rabbitmq.exchange;

import org.springframework.amqp.core.DirectExchange;

public class ExchangeManager {

    public static DirectExchange create(String exchangeName){
        return new DirectExchange(exchangeName);
    }

}
