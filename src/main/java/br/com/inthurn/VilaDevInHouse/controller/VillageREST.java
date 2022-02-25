package br.com.inthurn.VilaDevInHouse.controller;

import br.com.inthurn.VilaDevInHouse.model.projections.VillagerExternalIdAndName;
import br.com.inthurn.VilaDevInHouse.model.report.VillageReport;

import br.com.inthurn.VilaDevInHouse.model.transport.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.service.restservice.report.ReportService;
import br.com.inthurn.VilaDevInHouse.service.restservice.villageService.VillageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VillageREST {

    private  final VillageService villageService;
    private final ReportService reportService;

    public VillageREST(VillageService villageService, ReportService reportService) {
        this.villageService = villageService;
        this.reportService = reportService;
    }

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
    public ResponseEntity<List<VillagerExternalIdAndName>> getAllByName(@RequestParam String name){
        if(name == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            List<VillagerExternalIdAndName> villagers = villageService.getAllByName(name);
            return new ResponseEntity<List<VillagerExternalIdAndName>>(villagers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

//    @GetMapping("/villager/{id}")
//    public ResponseEntity<Object> listVillagerPerId(@PathVariable Integer id){
//        try {
//            return new ResponseEntity<Object>(villageService.listDetailsById(id), HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/villager/new")
    public ResponseEntity<String> addNew(@RequestBody VillagerDTO villagerDTO){
        try {
            villageService.save(villagerDTO);
            return ResponseEntity.ok("Usuário cadastrado!");
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping("/villager/delete")
//    public ResponseEntity<String> delete(@RequestParam Integer id){
//        try {
//            villageService.deleteVillager(id);
//            return ResponseEntity.ok("Usuário deletado");
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping("/villager/search")
//    public ResponseEntity<Object> listByMonth (@RequestParam Object month){
//        List<Object> villagersList = villageService.listVillagersByMonth(month);
//        return new ResponseEntity<>(villagersList, HttpStatus.OK);
//    }
//
//    @GetMapping("/villager/search/age")
//    public ResponseEntity<Object> listByAge(@RequestParam Integer age){
//        return new ResponseEntity<>(villageService.listVillagerByAge(age), HttpStatus.OK);
//
//    }

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
