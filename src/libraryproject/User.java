/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryproject;

import java.util.ArrayList;

/**
 *
 * @author Jingze Ma
 */
public class User {
    private String userName;
    private String lname;
    private String fname;
    private String password;
    private String country;
    private String province;
    private String city;
    private String address;
    private String zip;
    private String email;
    private String phone;
    private String myRole;
    private ArrayList<Record> myRecords;

    public User() {
      userName = "";
      lname = "";
      fname = "";
      password = "";
      country = "";
      province = "";
      city = "";
      address = "";
      zip = "";
      email = "";
      phone = "";
      myRole = "";
      myRecords = new ArrayList<Record>();  
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMyRole() {
        return myRole;
    }

    public void setMyRole(String myRole) {
        this.myRole = myRole;
    }

    public ArrayList<Record> getMyRecords() {
        return myRecords;
    }

    public void setMyRecords(ArrayList<Record> myRecords) {
        this.myRecords = myRecords;
    }   
    
}
