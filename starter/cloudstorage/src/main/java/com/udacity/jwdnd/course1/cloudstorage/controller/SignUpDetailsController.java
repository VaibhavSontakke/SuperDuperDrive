package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.UserDetails;
import com.udacity.jwdnd.course1.cloudstorage.services.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpDetailsController {

    private final UserDetailsService userDetailsService;

    public SignUpDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public String getSignUpPage(){
        return "signup";
    }

    @PostMapping()
    public String addUser(@ModelAttribute UserDetails userDetails, Model model){

        String signUpError = null;

        if (!userDetailsService.checkUserNameAvailability(userDetails.getUsername())){
            signUpError = "Ohh! user name is already taken";
        }

        if (signUpError == null){
            int rowAdded = userDetailsService.addNewUser(userDetails);
            if (rowAdded < 0){
                signUpError = "oops! error in sign up, Please try again";
            }
        }
        if (signUpError == null){
            model.addAttribute("signupSuccess", true);
            return "redirect:/login";
        }else {
            model.addAttribute("signUpError", signUpError);
        }

        return "login";
    }

}
