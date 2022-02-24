package br.com.inthurn.VilaDevInHouse.service.restservice.villageService;

import br.com.inthurn.VilaDevInHouse.interfaces.Convertible;
import br.com.inthurn.VilaDevInHouse.model.entity.Villager;
import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.repository.VillagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VillageService implements Convertible<Villager, VillagerDTO> {

    private final VillagerRepository villagerRepository;
    private final ModelMapper modelMapper;

    public VillageService(VillagerRepository villagerRepository, ModelMapper modelMapper) {
        this.villagerRepository = villagerRepository;
        this.modelMapper = modelMapper;
    }

    public List<VillagerDTO> listAllByName(String name){
        return villagerRepository
                .findAllByName(name)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

//    public VillagerDTO listDetailsById(Integer id) throws SQLException {
//        return convertToDTO(villagerDAO.listDetailsById(id));
//    }
//
//    public void addNew(VillagerDTO villagerDTO){
//       try {
//           villagerDAO.addNew(villagerDTO);
//       }catch (Exception e){
//           System.out.println(e.getMessage());
//       }
//
//    }
//
//    public List<Object> listVillagersByMonth(Object month){
//        try {
//            Integer monthInteger = Integer.parseInt(month.toString());
//            return villagerDAO
//                    .listPerMonth(monthInteger)
//                    .stream()
//                    .map(this::convertToDTO)
//                    .collect(Collectors.toList());
//        }catch (Exception e){
//            return villagerDAO
//                    .listPerMonth(month)
//                    .stream()
//                    .map(this::convertToDTO)
//                    .collect(Collectors.toList());
//        }
//    }
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
//    public List<VillagerDTO> listVillagerByAge(Integer age){
//        return villagerDAO.listByAge(age)
//                .stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<VillagerDTO> listAll() {
        return villagerRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean save(VillagerDTO villagerDTO) {
        try{
            villagerRepository.save(this.convertToEntity(villagerDTO));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String delete(String externalId) {
        return null;
    }

    @Override
    public Villager convertToEntity(VillagerDTO villagerDTO) {
        return modelMapper.map(villagerDTO, Villager.class);
    }

    @Override
    public VillagerDTO convertToDTO(Villager villager) {
        return modelMapper.map(villager, VillagerDTO.class);
    }
}
