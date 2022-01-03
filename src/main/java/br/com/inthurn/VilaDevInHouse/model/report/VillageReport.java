package br.com.inthurn.VilaDevInHouse.model.report;

import br.com.inthurn.VilaDevInHouse.model.transport.villager.VillagerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class VillageReport {

    private BigDecimal orcamento;
    private BigDecimal diferencaEntreOrcamentoEGasto;
    private BigDecimal gastoTotal;
    private VillagerDTO habitanteComMaiorCusto;

    public VillageReport(@Value("${village.budget}") BigDecimal orcamento, BigDecimal gastoTotal, VillagerDTO habitanteComMaiorCusto) {
        this.diferencaEntreOrcamentoEGasto = orcamento.subtract(gastoTotal);
        this.orcamento = orcamento;
        this.gastoTotal = gastoTotal;
        this.habitanteComMaiorCusto = habitanteComMaiorCusto;
    }
}
