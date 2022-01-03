package br.com.inthurn.VilaDevInHouse.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ValidationFilter extends BasicAuthenticationFilter {

    public static final String HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";

    public ValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request
                .getHeader(HEADER);

        if(token == null || !token.startsWith(PREFIX)){
            chain
                    .doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAutheticationToken(
            token
                    .replace(PREFIX, "")
        );

        SecurityContextHolder
                .getContext()
                .setAuthentication(authenticationToken);

        chain
                .doFilter(request, response);
    }

    UsernamePasswordAuthenticationToken getAutheticationToken(String token){
        try {

            String user = JWT
                    .require(Algorithm.HMAC512("8y/B?D(G+KbPeShVmYq3t6w9z$C&F)H@McQfTjWnZr4u7x!A%D*G-KaNdRgUkXp2"))
                    .build()
                    .verify(token)
                    .getSubject();

            if(user == null){
                return null;
            }

            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

        }catch (IOException e){
            throw new RuntimeException("Unable to authenticate the token", e);
        }
    }
}
