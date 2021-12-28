package br.com.inthurn.VilaDevInHouse.controller;

import br.com.inthurn.VilaDevInHouse.model.transport.appuser.AppUserDTO;
import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.service.restService.vilageService.VillageService;
import br.com.inthurn.VilaDevInHouse.service.restService.appservices.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VillageRest {

    @Autowired
    VillageService villageService;

    @GetMapping("/villagers")
    public List<VillagerDTO> listAllVillagers(){
        return villageService.listAllVillagers();
    }


    @GetMapping("/villager/{id}")
    public ResponseEntity<AppUserDTO> listVillagerPerId(@PathVariable Integer id){
            return null;
    }

}
