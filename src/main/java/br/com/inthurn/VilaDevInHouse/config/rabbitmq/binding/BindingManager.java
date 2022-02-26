package br.com.inthurn.VilaDevInHouse.config.rabbitmq.binding;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

public class BindingManager {

    private Queue queue;
    private DirectExchange directExchange;

    public BindingManager(Queue queue, DirectExchange directExchange) {
        this.queue = queue;
        this.directExchange = directExchange;
    }

    public Binding create(){
        return new Binding(this.queue.getName(), Binding.DestinationType.QUEUE, this.directExchange.getName(), this.queue.getName(), null);
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public DirectExchange getDirectExchange() {
        return directExchange;
    }

    public void setDirectExchange(DirectExchange directExchange) {
        this.directExchange = directExchange;
    }
}
