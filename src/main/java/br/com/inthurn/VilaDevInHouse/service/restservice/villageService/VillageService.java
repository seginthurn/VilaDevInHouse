package br.com.inthurn.VilaDevInHouse.service.restservice.villageService;

import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.projections.VillagerExternalIdAndName;
import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.repository.VillagerRepository;
import br.com.inthurn.VilaDevInHouse.service.restservice.appservices.UserService;
import br.com.inthurn.VilaDevInHouse.model.entity.utilities.UUIDManager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class VillageService{

    private final UserService userService;
    private final VillagerRepository villagerRepository;
    private final ModelMapper modelMapper;

    public VillageService(UserService userService, VillagerRepository villagerRepository, ModelMapper modelMapper) {
        this.userService = userService;
        this.villagerRepository = villagerRepository;
        this.modelMapper = modelMapper;
    }

    public List<VillagerExternalIdAndName> getAllByName(String name){
        return villagerRepository
                .getAllByName(name);
    }

    public VillagerDTO listDetailsByExternalId(String id){
        try {
            return convertToDTO(villagerRepository.findByExternalId(id));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
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
//
//
//    public VillagerEntity convertToEntity(VillagerDTO villagerDTO){
//            return new VillagerEntity(
//                    villagerDTO.getName(),
//                    villagerDTO.getSurname(),
//                    villagerDTO.getBirthday(),
//                    villagerDTO.getIncome(),
//                    villagerDTO.getCpf()
//            );
//
//    }
//
//    public VillagerDTO convertToDTO(VillagerEntity villagerEntity){
//        return new VillagerDTO(
//                villagerEntity.getId(),
//                villagerEntity.getName(),
//                villagerEntity.getSurname(),
//                villagerEntity.getBirthday(),
//                villagerEntity.getIncome(),
//                villagerEntity.getCpf()
//        );
//    }
//
//    public void deleteVillager(Integer id){
//        villagerDAO.deletePerId(id);
//        appUserDAO.delete(id);
//    }
//
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

    public String delete(String externalId) {
        return null;
    }

    public VillagerEntity convertToEntity(VillagerDTO villagerDTO) {
        return modelMapper.map(villagerDTO, VillagerEntity.class);
    }

    public VillagerDTO convertToDTO(VillagerEntity villager) {
        return modelMapper.map(villager, VillagerDTO.class);
    }

}
