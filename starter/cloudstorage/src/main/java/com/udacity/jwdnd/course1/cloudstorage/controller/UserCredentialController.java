package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.UserCredentialDetails;
import com.udacity.jwdnd.course1.cloudstorage.services.UserCredentialService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credential")
public class UserCredentialController {

    private final UserCredentialService userCredentialService;

    public UserCredentialController(UserCredentialService userCredentialService) {
        this.userCredentialService = userCredentialService;
    }

    @PostMapping("/add")
    public String addUserCredential(@ModelAttribute UserCredentialDetails userCredentialDetails, Authentication authentication, Model model){

        String errorMsg = null;
        String successMsg = null;

        if (userCredentialDetails.getId() != null){
            try{
                userCredentialService.updateCredential(userCredentialDetails);
                successMsg = "Credentials updated successfully";
            }catch (Exception e){
                errorMsg = "Error in updating credentials";
            }
        }else {
            int rowAdded = userCredentialService.addCredential(userCredentialDetails, authentication);
            if (rowAdded < 0){
                errorMsg = "Error in adding credential";
            }else {
                successMsg = "Credentials added successfully";
            }
        }

        if (errorMsg == null){
            model.addAttribute("successMsg", successMsg);
        }else {
            model.addAttribute("errorMsg", errorMsg);
        }
        return  "result";
    }

    @GetMapping("/delete/{credentialId}")
    public String deleteCredential(@PathVariable Integer credentialId, Model model){
        try{
            userCredentialService.deleteCredential(credentialId);
            model.addAttribute("success", "Credentials deleted !");
        }catch (Exception e){
            model.addAttribute("error", "error");
        }
        return "result";
    }

}
