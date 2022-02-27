package br.com.inthurn.VilaDevInHouse.model.transport;

import java.io.Serializable;

public class ReportMessageDTO implements Serializable {

    public static final Long serialVersionUID = 1L;

    private String email;
    private Integer retry;
    private Boolean vality;

    public ReportMessageDTO(String email, Integer retry, Boolean vality) {
        this.email = email;
        this.retry = retry;
        this.vality = vality;
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
}
