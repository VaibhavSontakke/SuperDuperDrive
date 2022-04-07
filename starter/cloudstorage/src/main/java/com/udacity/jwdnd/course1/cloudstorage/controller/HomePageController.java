package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteDetail;
import com.udacity.jwdnd.course1.cloudstorage.model.UserCredentialDetails;
import com.udacity.jwdnd.course1.cloudstorage.model.UserDetails;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomePageController {

    private NoteDetailsService noteDetailsService;
    private UserDetailsService userDetailsService;
    private UserCredentialService credentialService;
    private EncryptionService encryptionService;
    private FileService fileService;

    public HomePageController(NoteDetailsService noteDetailsService, UserDetailsService userDetailsService, UserCredentialService userCredentialService, EncryptionService encryptionService, FileService fileService) {
        this.noteDetailsService = noteDetailsService;
        this.userDetailsService = userDetailsService;
        this.credentialService = userCredentialService;
        this.encryptionService = encryptionService;
        this.fileService = fileService;
    }

    @GetMapping()
    public String getHomePageDetails(@ModelAttribute NoteDetail noteDetail, @ModelAttribute UserCredentialDetails userCredentialDetails, Model model, Authentication authentication){
        UserDetails userDetails = userDetailsService.getUser(authentication.getName());
        Integer userId = userDetails.getUserId();
        System.out.println(noteDetailsService.getAllNotes(userId));
        model.addAttribute("notes", noteDetailsService.getAllNotes(userId));
        model.addAttribute("credentials", credentialService.getAllCredentials(userId));
        model.addAttribute("credential", userCredentialDetails);
        model.addAttribute("encryptionService", encryptionService);
        model.addAttribute("files", fileService.getAllFiles(userId));
        return "home";
    }


}
