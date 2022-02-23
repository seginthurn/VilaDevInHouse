package br.com.inthurn.VilaDevInHouse.service.restservice.report;

import br.com.inthurn.VilaDevInHouse.dao.VillagerDAO;
import br.com.inthurn.VilaDevInHouse.model.report.VillageReport;
import br.com.inthurn.VilaDevInHouse.service.restservice.villageService.VillageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;

@Service
public class ReportService {

    private final VillagerDAO villagerDAO;
    private final VillageService villageService;

    public ReportService(VillagerDAO villagerDAO, VillageService villageService) {
        this.villagerDAO = villagerDAO;
        this.villageService = villageService;
    }

    @Value("${village.budget}")
    private BigDecimal villageBudget;

    public VillageReport villageReport() throws SQLException {
//        return new VillageReport(villageBudget, villagerDAO.villagerCost(), villageService.convertToDTO(villagerDAO.villagerWithHighestIncome()));
        return null;
    }

}
