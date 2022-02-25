package br.com.inthurn.VilaDevInHouse.repository;

import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.projections.VillagerExternalIdAndName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VillagerRepository extends JpaRepository<VillagerEntity, Long> {


    @Query("SELECT v.externalId as id, v.name as name, v.surname as surname from VillagerEntity v")
    List<VillagerExternalIdAndName> findAllVillagers();

    List<VillagerExternalIdAndName> getAllByName(String username);

}