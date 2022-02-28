package br.com.inthurn.VilaDevInHouse.model.projections;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public interface VillagerWithIncome {

    @Value("#{target.name + ' ' + target.surname}")
    String getName();

    @Value("#{target.externalId}")
    String getIdentifier();

    @Value("#{target.income}")
    String getIncome();

//    FOR TESTS ONLY
    void setName(String name);
    void setIdentifier(String identifier);
    void setIncome(String income);
}
