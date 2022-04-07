package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.UserCredentialDetails;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserCredentialMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
    List<UserCredentialDetails> getAllCredentials(Integer userId);

    void updateCredential(Integer credentialId, String url, String userName, String password);

    @Insert("INSERT INTO CREDENTIALS (url,username,key,password,userid) VALUES(#{url},#{username},#{key},#{password},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    int addCredential(UserCredentialDetails userCredentialDetails);


    @Update("UPDATE CREDENTIALS SET url = #{url}, username = #{username}, key = #{key}, password = #{password} WHERE credentialid = #{credentialId}")
    void update(UserCredentialDetails userCredentialDetails);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    void deleteCredential(Integer credentialId);

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialsId}")
    UserCredentialDetails getCredential(Integer credentialsId);

}
