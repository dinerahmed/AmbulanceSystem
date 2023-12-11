package com.example.ambulancesystem.all_class;

public class amb_avail {

    String user;
    String no;

    String location;


    public amb_avail(String user, String no, String location) {
        this.user = user;
        this.no = no;
        this.location = location;
    }

    public amb_avail() {
        this.user = "";
        this.no = "";
        this.location = "";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
