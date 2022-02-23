package br.com.inthurn.VilaDevInHouse.controller;

import br.com.inthurn.VilaDevInHouse.model.transport.UserDTO;
import br.com.inthurn.VilaDevInHouse.service.restservice.appservices.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserREST {

    private UserService userService;

    public UserREST(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/username")
    public UserDTO findByUsername(@RequestBody String username){
        return userService.findByUsername(username);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        if(userService.save(userDTO)){
            return new ResponseEntity<>("Usuãrio Salvo com sucesso!", HttpStatus.OK);
        }

        return new ResponseEntity<>("Erro ao cirar usuário", HttpStatus.BAD_REQUEST);
    }

}
