package br.com.inthurn.VilaDevInHouse.consumer;

import br.com.inthurn.VilaDevInHouse.model.transport.messages.ReportMessageDTO;
import br.com.inthurn.VilaDevInHouse.service.utilities.EmailServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailServiceImpl emailService;

    @RabbitListener(queues = "village.email")
    private void sendEmailWhenError(ReportMessageDTO message) {
        if(message.getVillageReport() == null){
            emailService.sendMail(message.getEmail(), "Falha ao gerar relatório", "Não foi possível gerar o relatório, tente novamente mais tarde");
        }else {
            emailService.sendMailWithAttachment(message.getEmail(), "Relatório da Vila", "Seu relatório foi gerado com sucesso!", "./Relatório.pdf");
        }


    }


}
