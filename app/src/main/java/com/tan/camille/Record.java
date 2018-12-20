package com.tan.camille;

public class Record {

    public String getFname() {
        return fname;
    }

    public String getGender() {
        return gender;
    }

    public long getAge() {
        return age;
    }

    public Record(String fname, String gender, int age) {

        this.fname = fname;
        this.gender = gender;
        this.age = age;
    }

    String fname;
    String gender;
    int age;


}