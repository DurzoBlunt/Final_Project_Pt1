package model;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;

public class User extends Person implements Serializable{

    private String username, email, password;
    private URL profilePic;

    public User(){}
    public User(String username, String email, String password, URL profilePic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
    }
    // Create account constructor
    public User (String fName, String lName, int ssn, LocalDate bday, String gender, String username,
                 String pw, String email, long phone, URL pic){
        super(fName, lName, gender, ssn, bday, phone);
        this.username = username;
        this.email = email;
        this.password = pw;
        this.profilePic = pic;
    }
    // Used for excel  sheet
    public User (String fName, String lName, String gender, String address, String city, String state, int zip,
                 double lat, double lon, LocalDate bday, long phone, String email){
        super(fName, lName, gender, address, city, state, zip, lat, lon, bday, phone);
        this.email = email;
    }
    // Contains all variables
    public User(String fName, String lName, String gender, String city, String state, int ssn, int zip, double lat, double lon,
                LocalDate bday, long phoneNum, String address, String username, String email, String password,
                URL profilePic) {
        super(fName, lName, gender, city, state, ssn, zip, lat, lon, bday, phoneNum, address);
        this.username = username;
        this.email = email;
        this.password = password;
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

    public URL getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(URL url) {
        this.profilePic = url;
    }

    public String toString(){
        return super.getfName() +"\n" + super.getlName() + "\n" + super.getSsn() + "\n" + super.getBday() + "\n" + super.getGender() + "\n" +
                getUsername() + "\n" + getPassword() + "\n" + getEmail() + "\n";
    }

}
