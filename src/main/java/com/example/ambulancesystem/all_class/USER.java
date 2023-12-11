package com.example.ambulancesystem.all_class;

public class USER extends person{

    String birth;

    public USER(String first_name, String last_name, String email, String phn_number, String pass, String address, String birth) {
        super(first_name, last_name, email, phn_number, pass, address);
        this.birth = birth;
    }

    public USER() {

    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
