package br.com.inthurn.VilaDevInHouse.consumer;

import br.com.inthurn.VilaDevInHouse.model.transport.messages.ReportMessageDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "village.email")
    private void sendEmailWhenError(ReportMessageDTO message){
        System.out.println("Mandando e-mail para " + message);
    }
}
