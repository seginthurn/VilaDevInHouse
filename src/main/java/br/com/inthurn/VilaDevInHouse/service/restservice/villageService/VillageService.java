//package br.com.inthurn.VilaDevInHouse.service.restservice.villageService;
//
//import br.com.inthurn.VilaDevInHouse.dao.AppUserDAO;
//import br.com.inthurn.VilaDevInHouse.dao.VillagerDAO;
//import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
//import br.com.inthurn.VilaDevInHouse.model.transport.villager.VillagerDTO;
//import org.springframework.stereotype.Service;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class VillageService {
//
//    private final VillagerDAO villagerDAO;
//    private final AppUserDAO appUserDAO;
//
//    public VillageService(VillagerDAO villagerDAO, AppUserDAO appUserDAO) {
//        this.villagerDAO = villagerDAO;
//        this.appUserDAO = appUserDAO;
//    }
//
//    public List<VillagerDTO> listAll(){
//        return villagerDAO
//                .listAll()
//                .stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public List<VillagerDTO> listAllByName(String name){
//        return villagerDAO
//                .listByName(name)
//                .stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
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
//
//}
