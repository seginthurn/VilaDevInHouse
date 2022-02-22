<<<<<<< Updated upstream
package br.com.inthurn.VilaDevInHouse.service.modelservice;

import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.UserDTO;
import br.com.inthurn.VilaDevInHouse.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID save(UserDTO userDTO){
        userRepository.save(userDTO.convertToEntity());
        return userDTO.getExternal_id();

    }

    public UserDTO findByUsername(String username){
        return userRepository.findByUsername(username).convertToDTO();
    }

    public List<UserDTO> findByUUID(UUID uuid){

        return new ArrayList<>(findByUUID(uuid));
    }



}
=======
//package br.com.inthurn.VilaDevInHouse.service.modelservice;
//
//import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
//import br.com.inthurn.VilaDevInHouse.model.transport.user.UserDTO;
//import br.com.inthurn.VilaDevInHouse.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//public class UserService {
//
//    private UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public UUID save(UserDTO userDTO){
//        try{
//            UserEntity user = userDTO.convertToEntity();
//            userRepository.save(user);
//            return user.getExternalId();
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//
//
//}
>>>>>>> Stashed changes
