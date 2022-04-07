package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.model.FileDetail;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/add")
    public String addFileDetails(@RequestParam("fileUpload") MultipartFile file, Model model, Authentication authentication) throws IOException {
       String errorMsg = null;
       String successMsg = null;

       if (file.isEmpty()){
           model.addAttribute("errorMsg", "Ohh noo! you are trying to upload empty file");
           return "result";
       }

       String fileName = file.getOriginalFilename();
        FileDetail getFileDetail = fileService.getFileByName(fileName);
        if (getFileDetail == null){
            try {
                fileService.addFile(file, authentication );
                successMsg = "Ola! File uploaded successfully";
            }catch (Exception e ){
                System.out.println(e.getMessage());
                errorMsg = "Error in uploading file";
            }
        }else {
            errorMsg = "Ohh! file already exist";
        }


       if (errorMsg == null){
           model.addAttribute("successMsg", successMsg);
       }else {
           model.addAttribute("errorMsg", errorMsg);
       }
        return "result";
    }


    @GetMapping("/delete/{fileId}")
    public String deleteFile(@PathVariable Integer fileId, Model model){
        try {
            fileService.deleteFile(fileId);
            model.addAttribute("success", "File deleted!");
        }catch (Exception e){
        }
        return "result";
    }


    @GetMapping("/download/{fileId}")
    public ResponseEntity downloadView(@PathVariable Integer fileId) {
        FileDetail fileDetail = fileService.downloadFile(fileId);

//        Reference- https://stackoverflow.com/questions/35680932/download-a-file-from-spring-boot-rest-service
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDetail.getName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(fileDetail.getData()));
    }
}

