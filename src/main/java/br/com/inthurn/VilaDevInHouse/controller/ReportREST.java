package br.com.inthurn.VilaDevInHouse.controller;

import br.com.inthurn.VilaDevInHouse.model.transport.messages.ReportMessageDTO;
import br.com.inthurn.VilaDevInHouse.service.infrastructure.messagebroker.rabbitmq.RabbitMQService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/reports")
public class ReportREST {

    private final RabbitMQService rabbitMQService;

    public ReportREST(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @GetMapping("/village")
    public ResponseEntity<Object> report(@RequestParam String email, @RequestParam Boolean vality){
        try {
            ReportMessageDTO reportMessageDTO = new ReportMessageDTO(email, 0, vality, null);
            rabbitMQService.sendMessage("village.report", reportMessageDTO);
            return new ResponseEntity<>("Solicitação efetuada com sucesso!", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
