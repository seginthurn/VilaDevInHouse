package br.com.inthurn.VilaDevInHouse.repository;

import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByUsername(String username);
    public List<UserEntity> findByExternalId(UUID externalId);

}
