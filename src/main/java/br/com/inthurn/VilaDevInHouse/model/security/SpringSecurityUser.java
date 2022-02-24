package br.com.inthurn.VilaDevInHouse.model.security;
;
import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class SpringSecurityUser implements UserDetails {

    private final Optional<UserEntity> user;

    public SpringSecurityUser(Optional<UserEntity> user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return user.orElse(new UserEntity()).getPassword();
    }

    @Override
    public String getUsername() {
        return user.orElse(new UserEntity()).getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
