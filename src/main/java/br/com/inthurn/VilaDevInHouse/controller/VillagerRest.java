<<<<<<< Updated upstream
package br.com.inthurn.VilaDevInHouse.controller;

import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.UserDTO;
import br.com.inthurn.VilaDevInHouse.service.modelservice.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/villager")
public class VillagerRest {

    private UserService userService;

    public VillagerRest(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO){
        try {
            UUID userUUID = userService.save(userDTO);
            return new ResponseEntity<>(userUUID.toString(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Algo não deu certo", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/username")
    public ResponseEntity<UserDTO> findByUsername(@RequestParam String username){
        ResponseEntity<UserDTO> response = new ResponseEntity<UserDTO>(userService.findByUsername(username), HttpStatus.OK);
        return  response;
    }

    @GetMapping("/uuid")
    public List<UserDTO> listByUUID(@RequestParam UUID uuid){
        return userService.findByUUID(uuid);
    }

}
=======
//package br.com.inthurn.VilaDevInHouse.controller;
//
//import br.com.inthurn.VilaDevInHouse.model.transport.user.UserDTO;
//import br.com.inthurn.VilaDevInHouse.service.modelservice.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/villager")
//public class VillagerRest {
//
//    private UserService userService;
//
//    public VillagerRest(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> save(@RequestBody UserDTO userDTO){
//        try {
//            UUID userUUID = userService.save(userDTO);
//            return new ResponseEntity<>(userUUID.toString(), HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>("Algo não deu certo", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//}
>>>>>>> Stashed changes
