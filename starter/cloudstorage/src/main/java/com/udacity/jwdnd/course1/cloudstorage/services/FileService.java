package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileDetailsMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserDetailsMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.FileDetail;
import com.udacity.jwdnd.course1.cloudstorage.model.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    private final FileDetailsMapper fileDetailsMapper;
    public final UserDetailsMapper userDetailsMapper;

    public FileService(FileDetailsMapper fileDetailsMapper, UserDetailsMapper userDetailsMapper) {
        this.fileDetailsMapper = fileDetailsMapper;
        this.userDetailsMapper = userDetailsMapper;
    }


    public int addFile(MultipartFile file, Authentication authentication) throws IOException {
        UserDetails currentUserDetails = userDetailsMapper.getUser(authentication.getName());
        Integer userId = currentUserDetails.getUserId();
        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        return fileDetailsMapper.addFile(new FileDetail(null, fileName, contentType, file.getSize(),  userId, file.getBytes()));
    }

    public List<FileDetail> getAllFiles(Integer userId){
//        System.out.println(fileMapper.getAllFiles(userId));
        return fileDetailsMapper.getAllFiles(userId);
    }

    public FileDetail getFileByName(String fileName){
        return fileDetailsMapper.getFileByName(fileName);
    }

    public void deleteFile(Integer fileId){
        fileDetailsMapper.deleteFile(fileId);
    }

    public FileDetail downloadFile(Integer fileId) {
        return fileDetailsMapper.getFile(fileId);
    }
}

