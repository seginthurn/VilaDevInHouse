package br.com.inthurn.VilaDevInHouse.model.security.report;

import br.com.inthurn.VilaDevInHouse.model.projections.VillagerWithIncome;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class VillageReport {

    private BigDecimal orcamento;
    private BigDecimal diferencaEntreOrcamentoEGasto;
    private BigDecimal gastoTotal;
    private VillagerWithIncome habitanteComMaiorCusto;

    public VillageReport(BigDecimal orcamento, BigDecimal gastoTotal, VillagerWithIncome habitanteComMaiorCusto) {
        this.orcamento = orcamento;
        this.diferencaEntreOrcamentoEGasto = orcamento.subtract(gastoTotal);
        this.gastoTotal = gastoTotal;
        this.habitanteComMaiorCusto = habitanteComMaiorCusto;
    }
}
