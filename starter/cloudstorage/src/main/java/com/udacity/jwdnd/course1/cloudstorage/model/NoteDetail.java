package com.udacity.jwdnd.course1.cloudstorage.model;

public class NoteDetail {

    Integer id;
    String title;
    String description;
    Integer userId;

    public NoteDetail(Integer id, String title, String description, Integer userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + id +
                ", noteTitle='" + title + '\'' +
                ", noteDescription='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
