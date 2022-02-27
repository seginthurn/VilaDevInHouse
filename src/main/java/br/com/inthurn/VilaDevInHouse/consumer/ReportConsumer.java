package br.com.inthurn.VilaDevInHouse.consumer;

import br.com.inthurn.VilaDevInHouse.model.security.report.VillageReport;
import br.com.inthurn.VilaDevInHouse.model.transport.ReportMessageDTO;
import br.com.inthurn.VilaDevInHouse.service.restservice.report.ReportService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
public class ReportConsumer {

    private final ReportService reportService;
    private final RabbitTemplate rabbitTemplate;

    public ReportConsumer(ReportService reportService, RabbitTemplate rabbitTemplate) {
        this.reportService = reportService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "village.report")
    private void generateReport(ReportMessageDTO reportMessageDTO){
        reportMessageDTO.addRetry();
            try {
                if(reportMessageDTO.getVality()){
                    VillageReport villageReport = reportService.villageReport();
                }else{
                    if(reportMessageDTO.getRetry() <= 3){
                        System.out.println("Reenviando para fila");
                        rabbitTemplate.convertAndSend("village.report", reportMessageDTO);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }

}
