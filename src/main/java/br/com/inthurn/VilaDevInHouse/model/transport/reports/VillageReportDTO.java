package br.com.inthurn.VilaDevInHouse.model.transport.reports;

import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.projections.VillagerWithIncome;
import br.com.inthurn.VilaDevInHouse.model.transport.entities.VillagerDTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class VillageReportDTO implements Serializable {

    private BigDecimal budget;
    private BigDecimal diferenceBetweenBudgetAndExpense;
    private BigDecimal totalExpense;
    private VillagerDTO villagerWithIncome;

    public VillageReportDTO() {
    }

    public VillageReportDTO(BigDecimal budget, BigDecimal diferenceBetweenBudgetAndExpense, BigDecimal totalExpense, VillagerDTO villagerWithIncome) {
        this.budget = budget;
        this.diferenceBetweenBudgetAndExpense = diferenceBetweenBudgetAndExpense;
        this.totalExpense = totalExpense;
        this.villagerWithIncome = villagerWithIncome;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getDiferenceBetweenBudgetAndExpense() {
        return diferenceBetweenBudgetAndExpense;
    }

    public void setDiferenceBetweenBudgetAndExpense(BigDecimal diferenceBetweenBudgetAndExpense) {
        this.diferenceBetweenBudgetAndExpense = diferenceBetweenBudgetAndExpense;
    }

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }

    public VillagerDTO getVillagerWithIncome() {
        return villagerWithIncome;
    }

    public void setVillagerWithIncome(VillagerDTO villagerWithIncome) {
        this.villagerWithIncome = villagerWithIncome;
    }

    @Override
    public String toString() {
        return "Relatório:" +
                "Orçamento: " + budget + "\n" +
                "Gasto Totais: " + totalExpense + "\n" +
                "Diferença entre orçamento e gastos: " + diferenceBetweenBudgetAndExpense + "\n" +
                "Morador com a maior renda: " + "{" + "\n" +
                "Nome: " + villagerWithIncome.getName() + ",\n"+
                "Renda: " + villagerWithIncome.getIncome() + ",\n"+
                "Identificador: " + villagerWithIncome.getExternalId() +"\n" +
                "}";
    }
}
