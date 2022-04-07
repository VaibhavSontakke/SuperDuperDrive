package com.udacity.jwdnd.course1.cloudstorage.services;


import com.udacity.jwdnd.course1.cloudstorage.mapper.UserDetailsMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.UserDetails;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationProviderService implements AuthenticationProvider {
    private UserDetailsMapper userDetailsMapper;
    private HashService hashService;

    public AuthenticationProviderService(UserDetailsMapper userDetailsMapper, HashService hashService) {
        this.userDetailsMapper = userDetailsMapper;
        this.hashService = hashService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
//        System.out.println(authentication);
//        System.out.println(authentication.getName());

        UserDetails userDetails = userDetailsMapper.getUser(username);
        if (userDetails != null) {
            String encodedSalt = userDetails.getSalt();
//            System.out.println(password);
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if (userDetails.getPassword().equals(hashedPassword)) {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}