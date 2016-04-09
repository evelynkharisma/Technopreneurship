package com.techno.technopreneurship.Object;

/**
 * Created by janistan on 4/9/2016.
 */
public class User {
    private String username;
    private String password;

    public User() {}

    public User(String user,String pass) {
        setUsername(user);
        setPassword(pass);
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }
}
