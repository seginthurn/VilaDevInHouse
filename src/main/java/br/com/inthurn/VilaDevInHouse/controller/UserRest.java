package br.com.inthurn.VilaDevInHouse.controller;

import br.com.inthurn.VilaDevInHouse.model.transport.appuser.AppUserDTO;
import br.com.inthurn.VilaDevInHouse.service.restService.appservices.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRest {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUserDTO>> listAllUsers(){

        return new ResponseEntity<>(appUserService.listAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<AppUserDTO> listUserPerId(@PathVariable Integer id){
        return new ResponseEntity(appUserService.listUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user/add")
    public ResponseEntity<String> addNewUser(AppUserDTO appUserDTO){
        try {
            appUserService.addNewUser(appUserDTO);
            return new ResponseEntity<>("Criado com sucesso!", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Algo deu errado...", HttpStatus.BAD_REQUEST);
        }
    }
}
