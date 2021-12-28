package br.com.inthurn.VilaDevInHouse.controller;

import br.com.inthurn.VilaDevInHouse.model.transport.villager.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.service.restService.villageService.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VillageRest {

    @Autowired
    VillageService villageService;

    @GetMapping("/villagers")
    public ResponseEntity<Object> listAllVillagers(){
        try{
            return new ResponseEntity<Object>(villageService.listAll(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/villager/{id}")
    public ResponseEntity<Object> listVillagerPerId(@PathVariable Integer id){
        try {
            return new ResponseEntity<Object>(villageService.listDetailsPerId(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/villager/new")
    public void addNew(VillagerDTO villagerDTO){
        villageService.addNew(villagerDTO);
    }

}
