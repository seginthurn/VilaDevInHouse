package br.com.inthurn.VilaDevInHouse.service.restservice.appservices;


import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import br.com.inthurn.VilaDevInHouse.model.security.SpringSecurityUser;
import br.com.inthurn.VilaDevInHouse.model.transport.UserDTO;
import br.com.inthurn.VilaDevInHouse.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private static ModelMapper modelMapper;


    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public UserDTO findByUsername(String username) {
        return convertToDTO(userRepository.findByUsername(username));
    }

    public Boolean save(UserDTO userDTO) {
        if (userDTO == null) {
            return false;
        }
        try {
           UserEntity user = modelMapper.map(userDTO, UserEntity.class);
           userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByUsername(username));

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username + " não foi localizado");
        }

        return new SpringSecurityUser(user);
    }


    public UserDTO convertToDTO(UserEntity user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public UserEntity convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

}
