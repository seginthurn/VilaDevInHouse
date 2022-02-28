package br.com.inthurn.VilaDevInHouse.config.rabbitmq.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BindingManager {

    private Queue queue;
    private DirectExchange directExchange;
    private Map<String, Object> args;

    public Binding create(){
        return new Binding(this.queue.getName(), Binding.DestinationType.QUEUE, this.directExchange.getName(), this.queue.getName(), this.args);
    }

}
