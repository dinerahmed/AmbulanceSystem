package com.example.ambulancesystem.all_class;

public class requ {

    String location;
    String amount;
    String time;
    String date;
    String driver;

    String user;

    public requ(String location, String amount, String time, String date, String driver, String user) {
        this.location = location;
        this.amount = amount;
        this.time = time;
        this.date = date;
        this.driver = driver;
        this.user = user;
    }

    public requ() {
        this.location = "";
        this.amount = "";
        this.time = "";
        this.date = "";
        this.driver = "";
        this.user = "";
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getDriver() {
        return driver;
    }


    public void setDriver(String driver) {
        this.driver = driver;
    }






    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
