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

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Integer id){
        appUserService.deleteById(id);
    }


}
