package com.example.ambulancesystem.all_class;


abstract class person
{
    private String name;
    private  String user;
    private String email;
    private String phn_number;
    private String pass;
    private String address;

    public person(String name, String user, String email, String phn_number, String pass, String address) {
        this.name = name;
        this.user = user;
        this.email = email;
        this.phn_number = phn_number;
        this.pass = pass;
        this.address = address;
    }

    public person() {
    }

    public String getPhn_number() {
        return phn_number;
    }

    public void setPhn_number(String phn_number) {
        this.phn_number = phn_number;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

