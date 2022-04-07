package com.udacity.jwdnd.course1.cloudstorage.model;

public class UserDetails {
    private Integer userId;
    private String username;
    private String firstName;
    private String lastName;
    private String salt;
    private String password;

    public UserDetails(Integer userId, String username, String salt, String password , String firstName, String lastName ) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salt = salt;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
//        System.out.println("username");
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
//        System.out.println("password");
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
//        System.out.println("getName");
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
