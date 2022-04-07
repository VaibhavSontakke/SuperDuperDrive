package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserCredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserDetailsMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.UserCredentialDetails;
import com.udacity.jwdnd.course1.cloudstorage.model.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class UserCredentialService {

    UserCredentialMapper userCredentialMapper;
    EncryptionService encryptionService;
    UserDetailsMapper userDetailsMapper;

    public UserCredentialService(UserCredentialMapper userCredentialMapper, EncryptionService encryptionService, UserDetailsMapper userDetailsMapper) {
        this.userCredentialMapper = userCredentialMapper;
        this.encryptionService = encryptionService;
        this.userDetailsMapper = userDetailsMapper;
    }

    public int addCredential(UserCredentialDetails userCredentialDetails, Authentication authentication){
//        System.out.println(credential);
        SecureRandom secureRandom = new SecureRandom();

        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
//        System.out.println("service");
//        System.out.println(credential);
        String key = Base64.getEncoder().encodeToString(salt);
//        System.out.println(key + "  key ");
        String encryptedPassword = encryptionService.encryptValue(userCredentialDetails.getPassword(), key);
//        System.out.println(encryptedPassword + "  password ");

        String decryptPassword = encryptionService.decryptValue(encryptedPassword, key);

        System.out.println("decrypted " + decryptPassword);

        UserDetails currentUserDetails = userDetailsMapper.getUser(authentication.getName());
        Integer userId = currentUserDetails.getUserId();
        String url = userCredentialDetails.getUrl();
        String userName = userCredentialDetails.getName();
        return userCredentialMapper.addCredential(new UserCredentialDetails(null, url, userName,  key, encryptedPassword, userId));

    }


    public List<UserCredentialDetails> getAllCredentials(Integer credentialId){
        return userCredentialMapper.getAllCredentials(credentialId);
    }


    public void updateCredential(UserCredentialDetails userCredentialDetails) {
        String encryptedPassword = encryptionService.encryptValue(userCredentialDetails.getPassword(), userCredentialDetails.getKey());
        userCredentialDetails.setPassword(encryptedPassword);
        userCredentialMapper.update(userCredentialDetails);
    }


    public void deleteCredential(Integer credentialId) {
        userCredentialMapper.deleteCredential(credentialId);
    }

    public UserCredentialDetails getCredentialById(Integer id) {
        return userCredentialMapper.getCredential(id);
    }

}

