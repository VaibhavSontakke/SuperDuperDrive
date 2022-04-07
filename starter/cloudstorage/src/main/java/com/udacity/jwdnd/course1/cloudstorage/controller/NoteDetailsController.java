package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteDetail;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteDetailsService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/note")
public class NoteDetailsController {

    NoteDetailsService noteDetailsService;
    UserDetailsService userDetailsService;

    public NoteDetailsController(UserDetailsService userDetailsService, NoteDetailsService noteDetailsService) {
        this.userDetailsService = userDetailsService;
        this.noteDetailsService = noteDetailsService;
    }


    @PostMapping("/addNote")
    public String addNoteDetails(@ModelAttribute NoteDetail noteDetail, Model m, Authentication authentication){

        String errorMsg = null;
        String successMsg = null;
        System.out.println("if note already present then we will get its id not null, so we will update this note else we will create new one");
        if (noteDetail.getId() != null){
            try {
                noteDetailsService.updateNote(noteDetail);
                successMsg = "Note updated successfully";
            }catch (Exception e){
                errorMsg = "Opps! something went wrong during updation ";
            }

        }else {
            int rowAdded = noteDetailsService.addNewNote(noteDetail, authentication);
            if (rowAdded < 0){
                errorMsg = "Error in adding note";

            }else {
                successMsg = "Note added successfully!";
            }
        }

        if (errorMsg == null){
            m.addAttribute("successMsg", successMsg);
        }else {
            m.addAttribute("errorMsg", errorMsg);
        }
        return "result";
    }

    @GetMapping("/delete/{noteId}")
    public String deleteNoteDetails(@PathVariable Integer noteId, Model model){
        try {
            noteDetailsService.deleteNote(noteId);
            model.addAttribute("success", "Note deleted !");
        }catch (Exception e){
            model.addAttribute("error", "Error in deleting note!");
        }

        return "result";
    }
}
