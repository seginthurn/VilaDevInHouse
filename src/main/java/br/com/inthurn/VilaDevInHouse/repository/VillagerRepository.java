package br.com.inthurn.VilaDevInHouse.repository;

import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.projections.VillagerExternalIdAndName;
import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VillagerRepository extends JpaRepository<VillagerEntity, Long> {


    @Query("SELECT v.externalId as id, v.name as name, v.surname as surname from VillagerEntity v")
    List<VillagerExternalIdAndName> findAllVillagers();

    @Query("SELECT v.externalId as id, v.name as name, v.surname as surname from VillagerEntity v where name like ?1")
    List<VillagerExternalIdAndName> getAllByName(String username);

    VillagerEntity findByExternalId(String externalId);

    @Modifying
    @Query("DELETE FROM VillagerEntity v where v.externalId = ?1 ")
    @Transactional
    void deleteByExternalId(String externalId);

}