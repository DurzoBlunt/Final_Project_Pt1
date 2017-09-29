package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
public class Person implements Serializable{

    private String fName, lName, gender;
    private int ssn;
    private LocalDate bday;

    public Person() {
        this.fName = "John";
        this.lName = "Smith";
    }

    public Person(String fName, String lName, int ssn, LocalDate bday, String gender){
//        fName = this.fName;
//        lName = this.lName;
//        ssn = this.ssn;
//        bday = this.bday;
//        gender = this.gender;
        this.setfName(fName);
        this.setlName(lName);
        this.setSsn(ssn);
        this.setBday(bday);
        this.setGender(gender);
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

    public String toString(){
        //fName, lName, ssn, bday, gender
        return getfName() +"\n" + getlName() + "\n" + getSsn() + "\n" + getBday() + "\n" + getGender();
    }

}
