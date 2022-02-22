package br.com.inthurn.VilaDevInHouse.repository;

import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
