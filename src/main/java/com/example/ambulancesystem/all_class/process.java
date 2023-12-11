package com.example.ambulancesystem.all_class;

public class process {
    String method;
    String trans;
    String id;
    String ref;
    String driver;
    String amount;
    String date;
    String user;
    String time;
    String location;
    String no;

    public process(String method, String trans, String id, String ref, String driver, String amount, String date, String user, String time, String location, String no) {
        this.method = method;
        this.trans = trans;
        this.id = id;
        this.ref = ref;
        this.driver = driver;
        this.amount = amount;
        this.date = date;
        this.user = user;
        this.time = time;
        this.location = location;
        this.no = no;
    }


    public process() {



    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
