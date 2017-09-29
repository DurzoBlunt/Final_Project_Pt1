package model;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;

public class User extends Person implements Serializable{

    private String username, email, password;
    private Long phoneNum;
    private URL profilePic;
    public User(){

    }

    public User(String username, String password, String email, Long phoneNum, URL profilePic) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.profilePic = profilePic;
    }

    public User(String fName, String lName, int ssn, LocalDate bday, String gender,
                String username, String password, String email, Long phoneNum, URL profilePic) {

        super(fName, lName, ssn, bday, gender);
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.profilePic = profilePic;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
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

    public Long getPhoneNum() {

        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {

        this.phoneNum = phoneNum;
    }

    public URL getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(URL url) {
        this.profilePic = profilePic;
    }

    public String toString(){
        return super.getfName() +"\n" + super.getlName() + "\n" + super.getSsn() + "\n" + super.getBday() + "\n" + super.getGender() + "\n" +
                getUsername() + "\n" + getPassword() + "\n" + getEmail() + "\n" + getPhoneNum();
    }

}
