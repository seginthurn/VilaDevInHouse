package br.com.inthurn.VilaDevInHouse.service.restService.report;

import br.com.inthurn.VilaDevInHouse.dao.VillagerDAO;
import br.com.inthurn.VilaDevInHouse.model.report.VillageReport;
import br.com.inthurn.VilaDevInHouse.service.restService.villageService.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;

@Service
public class ReportService {

    @Autowired
    VillagerDAO villagerDAO;

    @Autowired
    VillageService villageService;

    @Value("${village.budget}")
    private BigDecimal villageBudget;

    public VillageReport villageReport() throws SQLException {
        return new VillageReport(villageBudget, villagerDAO.villagerCost(), villageService.convertToDTO(villagerDAO.villagerWithHighestIncome()));
    }

}
