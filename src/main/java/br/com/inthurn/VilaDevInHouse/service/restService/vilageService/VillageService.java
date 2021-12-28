package br.com.inthurn.VilaDevInHouse.service.restService.vilageService;

import br.com.inthurn.VilaDevInHouse.dao.AppUserDAO;
import br.com.inthurn.VilaDevInHouse.dao.VillagerDAO;
import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageService {

    @Autowired
    VillagerDAO villagerDAO;

    @Autowired
    AppUserDAO appUserDAO;


    public List<VillagerDTO> listAllVillagers() {
        return villagerDAO.listAll();
    }






}
