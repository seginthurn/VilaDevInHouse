package br.com.inthurn.VilaDevInHouse.config.security;

import br.com.inthurn.VilaDevInHouse.security.AuthenticationFilter;
import br.com.inthurn.VilaDevInHouse.security.ValidationFilter;
import br.com.inthurn.VilaDevInHouse.service.infrastructure.security.encoder.Encryptor;
import br.com.inthurn.VilaDevInHouse.service.restService.appservices.AppUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AppUserService userService;
    private final Encryptor encryptor;

    public WebSecurityConfiguration(AppUserService userService, Encryptor encryptor) {
        this.userService = userService;
        this.encryptor = encryptor;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf()
               .disable()
               .authorizeRequests()
               .antMatchers(HttpMethod.POST, "/login")
               .permitAll()
               .anyRequest()
               .authenticated()
               .and()
               .addFilter(new AuthenticationFilter(authenticationManager()))
               .addFilter(new ValidationFilter(authenticationManager()))
               .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(encryptor);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration corsConfiguration = new CorsConfiguration()
                .applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source
                .registerCorsConfiguration("/**", corsConfiguration);

        return source;

    }
}
