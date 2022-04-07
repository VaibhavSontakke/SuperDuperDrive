package com.udacity.jwdnd.course1.cloudstorage.model;

public class UserCredentialDetails {

    private Integer id;
    private String url;
    private String name;
    private String password;
    private String key;
    private Integer userId;

    public UserCredentialDetails(Integer id, String url, String name, String key, String password, Integer userId) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.password = password;
        this.key = key;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "credintialId=" + id +
                ", url='" + url + '\'' +
                ", password='" + password + '\'' +
                ", key='" + key + '\'' +
                ", userId=" + userId +
                '}';
    }
}
