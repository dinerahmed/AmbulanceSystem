package com.example.ambulancesystem.all_class;

public class amb_show {

    String no;
    String user;
    String location;

    public amb_show(String no, String user, String location) {
        this.no = no;
        this.user = user;
        this.location = location;
    }

    public amb_show() {

        this.no = "";
        this.user = "";
        this.location = "";
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
