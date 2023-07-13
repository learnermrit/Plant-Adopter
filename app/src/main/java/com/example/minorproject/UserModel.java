package com.example.minorproject;

public class UserModel {
    private String name,email,password,aadharno,panno,contact,address,userType;

    public UserModel(String name, String email, String password, String aadharno, String panno,String contact, String address,String userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.aadharno = aadharno;
        this.panno = panno;
        this.contact=contact;
        this.address = address;
        this.userType=userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAadharno() {
        return aadharno;
    }

    public void setAadharno(String aadharno) {
        this.aadharno = aadharno;
    }

    public String getPanno() {
        return panno;
    }

    public void setPanno(String panno) {
        this.panno = panno;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UserModel() {
    }


}
