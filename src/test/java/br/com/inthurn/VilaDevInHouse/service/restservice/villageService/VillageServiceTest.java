package br.com.inthurn.VilaDevInHouse.service.restservice.villageService;

import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.projections.VillagerExternalIdAndName;
import br.com.inthurn.VilaDevInHouse.repository.VillagerRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class VillageServiceTest {

    @Mock
    private VillagerRepository villagerRepository;
    private VillageService villageService;

    public VillageServiceTest(VillagerRepository villagerRepository, VillageService villageService) {
        this.villagerRepository = villagerRepository;
        this.villageService = villageService;

    }

    @Test
    void getAllByName() {

    }

    @Test
    void listAll() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void convertToEntity() {
    }

    @Test
    void convertToDTO() {
    }
}