package br.com.inthurn.VilaDevInHouse.service.restservice.villageService;

import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.projections.VillagerExternalIdAndName;
import br.com.inthurn.VilaDevInHouse.model.transport.entities.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.repository.VillagerRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class VillageServiceTest {

    @Mock
    private VillagerRepository villagerRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private VillageService villageService;

    @BeforeEach
    public void setup(){
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
    void listDetailsByExternalId(){
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
    void shouldReturnTrueWhenVillagerIsSaved() {
        VillagerEntity villagerEntity = generateEntity();
        when(villagerRepository.save(villagerEntity)).thenReturn(villagerEntity);
        assertTrue(villageService.save(villagerEntity.convertToDTO()));

    }


    @Test
    void shouldGenerateExternalIdWhenExternalIdIsNull() {


    }

    @Test
    void convertToEntity() {
    }

    @Test
    void convertToDTO() {
    }

    private VillagerEntity generateEntity(){
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(new RoleEntity("ADMIN"));
        return new VillagerEntity("John", "Doe", "43212343093", new Date(1965, 10,27), new BigDecimal(102980), "8f3a0117-56d4-486a-82a1-a7399e14ff8e", new UserEntity("jhon@mail.com", "loremIps!um@", roles));
    }
}