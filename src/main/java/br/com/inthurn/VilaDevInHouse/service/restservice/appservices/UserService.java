package br.com.inthurn.VilaDevInHouse.service.restservice.appservices;

import br.com.inthurn.VilaDevInHouse.dao.AppUserDAO;
import br.com.inthurn.VilaDevInHouse.model.entity.User;
import br.com.inthurn.VilaDevInHouse.model.security.SpringSecurityUser;
import br.com.inthurn.VilaDevInHouse.model.transport.RoleDTO;
import br.com.inthurn.VilaDevInHouse.model.transport.UserDTO;
import br.com.inthurn.VilaDevInHouse.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final AppUserDAO appUserDAO;

    private final UserRepository userRepository;


    public UserService(AppUserDAO appUserDAO, UserRepository userRepository) {
        this.appUserDAO = appUserDAO;
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));

        if(user.isEmpty()){
            throw new UsernameNotFoundException(username + " não foi localizado");
        }

        return new SpringSecurityUser(user);
    }

//    public UserDTO findByUsername(String username){
//
//    }
//
//    public UserDTO convertToDTO(User user){
//        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//    }
    
}
