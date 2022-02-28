package br.com.inthurn.VilaDevInHouse.service.restservice.villageService;

import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.projections.VillagerExternalIdAndName;
import br.com.inthurn.VilaDevInHouse.model.transport.entities.UserDTO;
import br.com.inthurn.VilaDevInHouse.model.transport.entities.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.repository.VillagerRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import test.utils.GenerateUser;
import test.utils.GenerateVillager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static test.utils.GenerateVillager.generateEntity;

class VillageServiceTest {

    @Mock
    private VillagerRepository villagerRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private VillageService villageService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllByName() {
        String name = "Jhon";
        List<VillagerExternalIdAndName> villagerList = new ArrayList<>();

        when(villagerRepository.getAllByName(eq(name))).thenReturn(villagerList);

        assertEquals(villagerList, villageService.getAllByName(name));
        Mockito.verify(villagerRepository, times(1)).getAllByName(ArgumentMatchers.any(String.class));

    }

    @Test
    void listDetailsByExternalId() {
        VillagerDTO villagerDTO = generateEntity().convertToDTO();
        String externalId = villagerDTO.getExternalId();


        when(villagerRepository.findByExternalId(ArgumentMatchers.eq(externalId))).thenReturn(villagerDTO.convertToEntity());
        System.out.println(villageService.listDetailsByExternalId(externalId));
    }

    @Test
    void deleteById() {
        String externalId = "LOREM";
        doNothing().when(villagerRepository).deleteByExternalId(null);
        villageService.deleteById(externalId);

        Mockito.verify(villagerRepository, times(1)).deleteByExternalId(ArgumentMatchers.anyString());
    }

    @Test
    void listVillagersByMonth() {
        Integer month = 10;
        List<VillagerExternalIdAndName> villagers = new ArrayList<>();

        when(villagerRepository.getAllByBirthdayMonth(eq(month))).thenReturn(villagers);

        assertEquals(villagers, villageService.listVillagersByMonth(month));
        Mockito.verify(villagerRepository, times(1)).getAllByBirthdayMonth(ArgumentMatchers.anyInt());

    }

    @Test
    void listVillagerByAge() {
        Integer age = 10;
        List<VillagerExternalIdAndName> villagers = new ArrayList<>();

        when(villagerRepository.getAllByAge(eq(age))).thenReturn(villagers);

        assertEquals(villagers, villageService.listVillagerByAge(age));
        Mockito.verify(villagerRepository, times(1)).getAllByAge(ArgumentMatchers.anyInt());
    }

    @Test
    void listAll() {
        List<VillagerExternalIdAndName> villagers = new ArrayList<>();

        when(villagerRepository.findAllVillagers()).thenReturn(villagers);

        assertEquals(villagers, villageService.listAll());
        Mockito.verify(villagerRepository, times(1)).findAllVillagers();
    }

    @Test
    void save() {
        VillagerEntity villagerEntity = generateEntity();

        when(villagerRepository.save(any(VillagerEntity.class))).thenReturn(villagerEntity);
        assertEquals(VillagerDTO.class, villageService.save(villagerEntity.convertToDTO()).getClass());

    }

    @Test
    void shouldSetExternalIdWhenIsNull() {
        VillagerEntity villagerEntity = generateEntity();
        villagerEntity.convertToDTO().setExternalId(null);
        when(villagerRepository.save(any(VillagerEntity.class))).thenReturn(villagerEntity);
        VillagerDTO villagerDTO = villageService.save(villagerEntity.convertToDTO());
        assertNotNull(villagerDTO.getExternalId());

    }

    @Test
    void convertToEntity() {
        VillagerDTO villagerDTO = generateEntity().convertToDTO();
        VillagerEntity villagerEntity = villagerDTO.convertToEntity();
        when(modelMapper.map(villagerDTO, VillagerEntity.class)).thenReturn(villagerEntity);
        assertEquals(villagerEntity, villageService.convertToEntity(villagerDTO));
        Mockito.verify(modelMapper, times(1)).map(ArgumentMatchers.any(VillagerDTO.class), ArgumentMatchers.eq(VillagerEntity.class));
    }

    @Test
    void convertToDTO() {
        VillagerDTO villagerDTO = generateEntity().convertToDTO();
        VillagerEntity villagerEntity = villagerDTO.convertToEntity();
        when(modelMapper.map(villagerEntity, VillagerDTO.class)).thenReturn(villagerDTO);
        assertEquals(villagerDTO, villageService.convertToDTO(villagerEntity));
        Mockito.verify(modelMapper, times(1)).map(ArgumentMatchers.any(VillagerEntity.class), ArgumentMatchers.eq(VillagerDTO.class));
    }
}