package br.com.inthurn.VilaDevInHouse.controller;

import br.com.inthurn.VilaDevInHouse.model.transport.UserDTO;
import br.com.inthurn.VilaDevInHouse.service.restservice.appservices.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserREST {

    private UserService userService;

//    @GetMapping("/username")
//    public UserDTO findByUsername(@RequestBody String username){
//        UserDTO userDTO = userService.loadUserByUsername(username);
//    }

}
