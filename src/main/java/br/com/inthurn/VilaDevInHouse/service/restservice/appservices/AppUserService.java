//package br.com.inthurn.VilaDevInHouse.service.restservice.appservices;
//
//import br.com.inthurn.VilaDevInHouse.dao.AppUserDAO;
//import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
//import br.com.inthurn.VilaDevInHouse.model.security.SpringSecurityUser;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AppUserService implements UserDetailsService {
//
//    private final AppUserDAO appUserDAO;
//
//
//    public AppUserService(AppUserDAO appUserDAO) {
//        this.appUserDAO = appUserDAO;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UserEntity> user = appUserDAO.findByLogin(username);
//
//        if(user.isEmpty()){
//            throw new UsernameNotFoundException(username + " não foi localizado");
//        }
//
//        return new SpringSecurityUser(user);
//    }
//
//}
