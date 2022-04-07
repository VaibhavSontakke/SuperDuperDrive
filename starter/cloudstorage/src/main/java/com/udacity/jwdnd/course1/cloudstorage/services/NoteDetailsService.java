package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteDetailsMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserDetailsMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteDetail;
import com.udacity.jwdnd.course1.cloudstorage.model.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteDetailsService {
    NoteDetailsMapper noteDetailsMapper;
    UserDetailsMapper userDetailsMapper;

    public NoteDetailsService(NoteDetailsMapper noteDetailsMapper, UserDetailsMapper userDetailsMapper) {
        this.noteDetailsMapper = noteDetailsMapper;
        this.userDetailsMapper = userDetailsMapper;
    }

    public int addNewNote(NoteDetail noteDetail, Authentication authentication){
        UserDetails currentUserDetails = userDetailsMapper.getUser(authentication.getName());
        Integer userId = currentUserDetails.getUserId();
        String noteTitle = noteDetail.getTitle();
        String noteDescription = noteDetail.getDescription();
        return noteDetailsMapper.addNote(new NoteDetail(null, noteTitle, noteDescription, userId));
    }

    public List<NoteDetail> getAllNotes(Integer userId){
        return noteDetailsMapper.getAllNotes(userId);
    }

    public void updateNote(NoteDetail noteDetail){
        noteDetailsMapper.update(noteDetail);
    }

    public void deleteNote(Integer noteId){
        noteDetailsMapper.deleteNote(noteId);
    }
}
//        return userMapper.addUser(new User(null, uName, encodedSalt, hashedPassword, fName, lName));
