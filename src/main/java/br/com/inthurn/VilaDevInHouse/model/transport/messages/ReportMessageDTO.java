package br.com.inthurn.VilaDevInHouse.model.transport.messages;

import br.com.inthurn.VilaDevInHouse.model.report.VillageReport;
import br.com.inthurn.VilaDevInHouse.model.transport.reports.VillageReportDTO;

import java.io.Serializable;

public class ReportMessageDTO implements Serializable {

    public static final Long serialVersionUID = 1L;

    private String email;
    private Integer retry;
    private Boolean vality;
    private VillageReportDTO villageReport;

    public ReportMessageDTO(String email, Integer retry, Boolean vality, VillageReportDTO villageReport) {
        this.email = email;
        this.retry = retry;
        this.vality = vality;
        this.villageReport = villageReport;
    }

    public Boolean getVality() {
        return vality;
    }

    public void setVality(Boolean vality) {
        this.vality = vality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }

    public void addRetry(){
        this.retry+=1;
    }

    public VillageReportDTO getVillageReport() {
        return villageReport;
    }

    public void setVillageReport(VillageReportDTO villageReport) {
        this.villageReport = villageReport;
    }

    @Override
    public String toString() {
        return "ReportMessageDTO{" + "\n" +
                "email='" + email + ",\n" +
                "message=" + villageReport +
                '}';
    }
}
