package br.com.inthurn.VilaDevInHouse.model.security;

import br.com.inthurn.VilaDevInHouse.model.entity.AppUserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class SpringSecurityUser implements UserDetails {

    private final Optional<AppUserEntity> user;

    public SpringSecurityUser(Optional<AppUserEntity> user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return user.orElse(new AppUserEntity()).getPassword();
    }

    @Override
    public String getUsername() {
        return user.orElse(new AppUserEntity()).getUsername();
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
