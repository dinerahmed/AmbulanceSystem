package com.example.ambulancesystem.all_class;

public class History {

    String driver;
    String amount;
    String date;
    String user;
    String time;
    String location;


    public History(String driver, String amount, String date, String user, String time, String location) {
        this.driver = driver;
        this.amount = amount;
        this.date = date;
        this.user = user;
        this.time = time;
        this.location = location;
    }

    public History() {
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
