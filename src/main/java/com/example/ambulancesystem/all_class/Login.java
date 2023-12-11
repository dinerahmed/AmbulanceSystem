package com.example.ambulancesystem.all_class;

public class Login {

    String user;
    String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Login() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
