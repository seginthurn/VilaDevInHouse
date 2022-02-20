package br.com.inthurn.VilaDevInHouse.service.modelservice;

import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.UserDTO;
import br.com.inthurn.VilaDevInHouse.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID save(UserDTO userDTO){
        try{
            UserEntity user = userDTO.convertToEntity();
            userRepository.save(user);
            return user.getExternal_id();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }




}
