package br.com.inthurn.VilaDevInHouse.service.restservice.villageService;

import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.projections.VillagerExternalIdAndName;
import br.com.inthurn.VilaDevInHouse.model.transport.entities.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.repository.VillagerRepository;
import br.com.inthurn.VilaDevInHouse.service.utilities.UUIDManager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class VillageService{

    private final VillagerRepository villagerRepository;
    private final ModelMapper modelMapper;

    public VillageService(VillagerRepository villagerRepository, ModelMapper modelMapper) {
        this.villagerRepository = villagerRepository;
        this.modelMapper = modelMapper;
    }

    public List<VillagerExternalIdAndName> getAllByName(String name){
        return villagerRepository
                .getAllByName(name);
    }

    public VillagerDTO listDetailsByExternalId(String externalId){
        VillagerDTO villagerDTO = villagerRepository.findByExternalId(externalId).convertToDTO();
        return villagerDTO;
    }

    public void deleteById(String id){
        try {
            villagerRepository.deleteByExternalId(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public List<VillagerExternalIdAndName> listVillagersByMonth(Integer month){
        try {
            return villagerRepository
                    .getAllByBirthdayMonth(month);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<VillagerExternalIdAndName> listVillagerByAge(Integer age){
        Integer year = (Calendar.getInstance().get(Calendar.YEAR) - age);
        return villagerRepository.getAllByAge(year);
    }


    public List<VillagerExternalIdAndName> listAll() {
        return villagerRepository.findAllVillagers();
    }

    public Boolean save(VillagerDTO villagerDTO) {
        try{
            if(villagerDTO.getExternalId() == null){
                villagerDTO.setExternalId(UUIDManager.generate());
            }
            villagerRepository.save(this.convertToEntity(villagerDTO));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public VillagerEntity convertToEntity(VillagerDTO villagerDTO) {
        return modelMapper.map(villagerDTO, VillagerEntity.class);
    }

    public VillagerDTO convertToDTO(VillagerEntity villager) {
        return modelMapper.map(villager, VillagerDTO.class);
    }

}
