package br.com.inthurn.VilaDevInHouse.model.report;

import br.com.inthurn.VilaDevInHouse.model.projections.VillagerWithIncome;
import br.com.inthurn.VilaDevInHouse.model.transport.entities.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.model.transport.reports.VillageReportDTO;

import java.math.BigDecimal;

public class VillageReport {

    private BigDecimal budget;
    private BigDecimal diferenceBetweenBudgetAndExpense;
    private BigDecimal totalExpense;
    private VillagerWithIncome villagerWithIncome;

    public VillageReport(BigDecimal budget, BigDecimal totalExpense, VillagerWithIncome villagerWithIncome) {
        this.budget = budget;
        this.diferenceBetweenBudgetAndExpense = budget.subtract(totalExpense);
        this.totalExpense = totalExpense;
        this.villagerWithIncome = villagerWithIncome;
    }

    public VillageReport(BigDecimal budget, BigDecimal diferenceBetweenBudgetAndExpense, BigDecimal totalExpense, VillagerWithIncome villagerWithIncome) {
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

    public VillagerWithIncome getVillagerWithIncome() {
        return villagerWithIncome;
    }

    public void setVillagerWithIncome(VillagerWithIncome villagerWithIncome) {
        this.villagerWithIncome = villagerWithIncome;
    }

    @Override
    public String toString() {
        return "VillageReport{" +
                "budget=" + budget +
                ", diferenceBetweenBudgetAndExpense=" + diferenceBetweenBudgetAndExpense +
                ", totalExpense=" + totalExpense +
                ", villagerWithIncome=" + villagerWithIncome +
                '}';
    }

    public VillageReportDTO generateDTO(){
        return new VillageReportDTO(this.budget, this.totalExpense, this.diferenceBetweenBudgetAndExpense, new VillagerDTO(villagerWithIncome.getName(), new BigDecimal(villagerWithIncome.getIncome()), villagerWithIncome.getIdentifier()));
    }
}
