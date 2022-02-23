package br.com.inthurn.VilaDevInHouse.repository;

import br.com.inthurn.VilaDevInHouse.model.entity.Villager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillagerRepository extends JpaRepository<Villager, Long> {
}