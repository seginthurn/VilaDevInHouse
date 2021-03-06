package br.com.inthurn.VilaDevInHouse.model.projections;

import org.springframework.beans.factory.annotation.Value;

public interface VillagerExternalIdAndName {

    @Value("#{target.name + ' ' + target.surname}")
    String getName();

    @Value("#{target.id}")
    String getIdentifier();

}
