package com.example.ambulancesystem.all_class;

public class Ambulance extends person{

    String v_no;

    public Ambulance(String first_name, String last_name, String email, String phn_number, String pass, String address, String v_no) {
        super(first_name, last_name, email, phn_number, pass, address);
        this.v_no = v_no;
    }

    public Ambulance() {

    }

    public String getV_no() {
        return v_no;
    }

    public void setV_no(String v_no) {
        this.v_no = v_no;
    }
}
