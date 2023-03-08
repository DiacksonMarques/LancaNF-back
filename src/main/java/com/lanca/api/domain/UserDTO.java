package com.lanca.api.domain;

import com.lanca.api.model.User;

import java.util.Base64;

public class UserDTO {

    private Long Id;
    private String Name;
    private String Surname;
    private String tokenUser;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(String tokenUser) {
        this.tokenUser = tokenUser;
    }

    public void setUser(User user){
        this.Id = user.getId();
        this.Name = user.getName();
        this.Surname = user.getSurname();
        this.tokenUser = Base64.getEncoder().encodeToString(new String(user.getUserName()+user.getPassword()).getBytes());
    }
}
