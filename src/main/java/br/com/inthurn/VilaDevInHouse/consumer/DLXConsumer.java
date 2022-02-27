package br.com.inthurn.VilaDevInHouse.consumer;

import br.com.inthurn.VilaDevInHouse.model.transport.messages.ReportMessageDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class DLXConsumer {

    RabbitTemplate rabbitTemplate;

    public DLXConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "village.dlx")
    private void getDeadLetters(ReportMessageDTO message){
        rabbitTemplate.convertAndSend("village.email",message);
    }

}
