package br.com.inthurn.VilaDevInHouse.config.rabbitmq.queue;

import org.springframework.amqp.core.Queue;

public class QueueManager {

    public static Queue create(String queuename){
        return new Queue(queuename);
    }

}
