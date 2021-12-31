package br.com.inthurn.VilaDevInHouse.controller;

import br.com.inthurn.VilaDevInHouse.model.report.VillageReport;
import br.com.inthurn.VilaDevInHouse.model.transport.villager.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.service.restService.report.ReportService;
import br.com.inthurn.VilaDevInHouse.service.restService.villageService.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VillageRest {

    @Autowired
    VillageService villageService;

    @Autowired
    ReportService reportService;

    @GetMapping("/villagers")
    public ResponseEntity<Object> listAllVillagers(){
        try{
            return new ResponseEntity<Object>(villageService.listAll(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/villagers/search")
    public ResponseEntity<Object> listVillagersByName(@RequestParam String name){
        if(name == null){
            return new ResponseEntity<>("ERRO: O nome não pode estar vazio!", HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<Object>(villageService.listAllByName(name), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/villager/{id}")
    public ResponseEntity<Object> listVillagerPerId(@PathVariable Integer id){
        try {
            return new ResponseEntity<Object>(villageService.listDetailsById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/villager/new")
    public void addNew(VillagerDTO villagerDTO){
        villageService.addNew(villagerDTO);
    }

    @DeleteMapping("/villager/delete")
    public void delete(@RequestParam Integer id){
        villageService.deleteVillager(id);
    }

    @GetMapping("/villager/search")
    public ResponseEntity<Object> listByMonth (@RequestParam Object month){
        List<Object> villagersList = villageService.listVillagersByMonth(month);
        return new ResponseEntity<>(villagersList, HttpStatus.OK);
    }

    @GetMapping("/villager/search/age")
    public ResponseEntity<Object> listByAge(@RequestParam Integer age){
        return new ResponseEntity<>(villageService.listVillagerByAge(age), HttpStatus.OK);

    }

    @GetMapping("/village/report")
    public ResponseEntity<VillageReport> report(){
       try {
           return new ResponseEntity<>(reportService.villageReport(), HttpStatus.OK);
       }catch (SQLException e){
           e.printStackTrace();
           return null;
       }
    }

}
