package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
public class Person implements Serializable{
    private String fName;
    private String lName;
    private String gender;
    private String city;
    private String state;
    private String address;
    private int ssn, zip, location;
    private LocalDate bday;
    private long phoneNum;

    public Person() {
        this.fName = "John";
        this.lName = "Smith";
    }

    public Person(String fName, String lName, String gender, String city, String state, int ssn, int zip,
                  int location, LocalDate bday, long phoneNum, String address) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.city = city;
        this.state = state;
        this.ssn = ssn;
        this.zip = zip;
        this.location = location;
        this.bday = bday;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String toString(){ return getfName() +"\n" + getlName() + "\n" + getSsn() + "\n" + getBday() + "\n" + getGender(); }

    public long getPhoneNum() { return phoneNum; }

    public void setPhoneNum(long phoneNum) { this.phoneNum = phoneNum; }
}
