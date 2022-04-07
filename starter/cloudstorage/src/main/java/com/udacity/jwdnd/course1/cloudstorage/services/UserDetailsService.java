package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserDetailsMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.UserDetails;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserDetailsService {

    private final UserDetailsMapper userDetailsMapper;
    private final HashService hashService;
    private final EncryptionService encryptionService;

    public UserDetailsService(UserDetailsMapper userDetailsMapper, HashService hashService, EncryptionService encryptionService) {
        this.userDetailsMapper = userDetailsMapper;
        this.hashService = hashService;
        this.encryptionService = encryptionService;
    }

    public boolean checkUserNameAvailability(String username){
        return userDetailsMapper.getUser(username) == null;
    }

    public int addNewUser(UserDetails userDetails) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(userDetails.getPassword(), encodedSalt);
//        System.out.println(user.getFirstName());
        String fName = userDetails.getFirstName();
//        System.out.println(fName);
        String lName = userDetails.getLastName();
//        System.out.println(lName);
        String uName = userDetails.getUsername();
//        System.out.println(uName);
//        System.out.println("eeeeeeeeeeeeeee");
        return userDetailsMapper.addUser(new UserDetails(null, uName, encodedSalt, hashedPassword, fName, lName));
    }

    public UserDetails getUser(String username){
        return userDetailsMapper.getUser(username);
    }

}
