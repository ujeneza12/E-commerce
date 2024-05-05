package com.rca.ac.rw.Ecommerce.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.rca.ac.rw.Ecommerce.model.LocalUser;
import com.rca.ac.rw.Ecommerce.model.dao.LocalUserDAO;
import com.rca.ac.rw.Ecommerce.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    private JWTService jwtService;
    private LocalUserDAO localUserDAO;

    public JWTRequestFilter(JWTService jwtService,LocalUserDAO localUserDAO){
        this.jwtService =jwtService;
        this.localUserDAO = localUserDAO;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{

        String tokenHeader= request.getHeader("authorization");
        if(tokenHeader !=null && tokenHeader.startsWith("Bearer ")){
            String token= tokenHeader.substring(7);
            try{
                String email =jwtService.getEmail(token);
                Optional<LocalUser> opUser = localUserDAO.findByEmailIgnoreCase(email);

                if(opUser.isPresent()){
                    LocalUser user = opUser.get();
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            }catch(JWTDecodeException ex){


            }
        }
        filterChain.doFilter(request,response);

    }

}
