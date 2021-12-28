package br.com.inthurn.VilaDevInHouse.service.restService.appservices;

import br.com.inthurn.VilaDevInHouse.dao.AppUserDAO;
import br.com.inthurn.VilaDevInHouse.dao.VillagerDAO;
import br.com.inthurn.VilaDevInHouse.model.entity.AppUserEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.model.transport.appuser.AppUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserService {

    @Autowired
    AppUserDAO appUserDAO;


    public List<AppUserDTO> listAllUsers() {
        return appUserDAO
                .listAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void addNewUser(AppUserDTO appUserDTO){
        appUserDAO.addNew(convertToEntity(appUserDTO));
    }


    public AppUserDTO listUserById(Integer id){
        return this.convertToDTO(appUserDAO.listDetailsPerId(id));
    }

    public static AppUserEntity convertToEntity(AppUserDTO appUserDTO){
        return new AppUserEntity(
                appUserDTO.getUsername(),
                appUserDTO.getPassword()
        );
    }
    public AppUserDTO convertToDTO(AppUserEntity appUserEntity){
        return new AppUserDTO(
                appUserEntity.getUsername(),
                appUserEntity.getPassword()
        );
    }

}
