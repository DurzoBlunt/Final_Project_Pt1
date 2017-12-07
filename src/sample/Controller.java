package sample;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.regex.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.User;
import model.AccountDB;

public class Controller {

    @FXML
    TextField inputUsername;
    @FXML
    TextField inputFirstName;
    @FXML
    TextField inputLastName;
    @FXML
    TextField inputEmail;
    @FXML
    TextField inputSSN;
    @FXML
    TextField inputPhoneNumber;
    @FXML
    PasswordField inputPassword;
    @FXML
    PasswordField inputConfirmPassword;
    @FXML
    DatePicker inputBirthDate;
    @FXML
    CheckBox pickGenderMale;
    @FXML
    CheckBox pickGenderFemale;
    @FXML
    Label usernameError;
    @FXML
    Label passwordError;
    @FXML
    Label confirmPasswordError;
    @FXML
    Label firstNameError;
    @FXML
    Label lastNameError;
    @FXML
    Label emailError;
    @FXML
    Label SSNError;
    @FXML
    Label phoneNumberError;
    @FXML
    Label accountCreated;
    @FXML
    Button btnChoosePic;
    @FXML
    TextField filePathViewer;
    @FXML
    ImageView picture;
    @FXML
    Hyperlink signUpLink;
    @FXML
    TextField loginUsername;
    @FXML
    PasswordField loginPassword;
    @FXML
    Button loginBTN;
    @FXML
    Label loginUsernameError;
    @FXML
    Label loginPasswordError;
    @FXML
    ImageView loginPic;
    @FXML





    boolean hasPicChanged = false;
    URL picUrl = getClass().getResource("NullPhoto.jpg");


    public void createAccount(){
        if(authenticate()) {
            accountCreated.setText("SUCCESSFUL!!");
            User newUser = new User(inputFirstName.getText(), inputLastName.getText(), Integer.parseInt(inputSSN.getText()),
                    inputBirthDate.getValue(), genderPicker(), inputUsername.getText(), inputPassword.getText(),
                    inputEmail.getText(), Long.parseLong(inputPhoneNumber.getText()), picUrl);

            AccountDB.addAccount(newUser); // Adds account to DB, then writes to file
            System.out.println(AccountDB.getAccountList());
        }
    }

    public void displayCreateAccountPage(ActionEvent actionEvent) throws Exception{
        Stage primaryStage = (Stage) ((Hyperlink)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        primaryStage.setTitle("There is no title yet");
        primaryStage.setScene(new Scene(root, 685, 732));
        primaryStage.show();
    }

    public void loginAuthenticator() {
        if(AccountDB.checkAccountExistence(loginUsername.getText())){
            if(loginPassword.getText().equals(AccountDB.getCurrentUser().getPassword())){

                loginPic.setImage(new Image(String.valueOf(AccountDB.currentUser.getProfilePic())));;
                System.out.println("Welcome " + AccountDB.getCurrentUser().getUsername());
            }
        }
    }

    public String genderPicker(){
        String tempGender = "";
        if(pickGenderMale.isSelected()){
            tempGender = "Male";
            return tempGender;
        }
        if(pickGenderFemale.isSelected()){
            tempGender = "Female";
            return tempGender;
        }

        return tempGender;
    }

    public boolean checkPassword(){
        //Check PW reqs
        boolean success = false;
        if(Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=?])(?=\\S+$).{8,}", inputPassword.getText())){
            passwordError.setText("");
            //Check matching PW
            success = true;
            if(!inputPassword.getText().equals(inputConfirmPassword.getText())){

                confirmPasswordError.setText("Passwords do not match");
                success = false;
            }
            else{
                confirmPasswordError.setText("");
            }
        }
        else{
            success = false;
            passwordError.setText("Password Min.Req: 1 lowercase, 1 UPPERCASER,1 Number, 1 Symbol(!@#$%^&*+=?)");
        }
        return success;
    }

    public boolean checkUsername(){
        boolean success = false;
        if(!Pattern.matches("^[a-zA-Z.]{2,20}$", inputUsername.getText() )){
            usernameError.setText("Username must contain 2-20 letters and/or numbers long");
            success = false;
        }
        else{
            if(!AccountDB.checkAccountExistence(inputUsername.getText())){
                usernameError.setText("");
                success = true;
            }
            else{
                usernameError.setText("Username already exists");
                success = false;
            }
        }
        return success;
    }

    public boolean checkFirstName(){
        boolean success;
        if(!Pattern.matches("^[\\D]+$", inputFirstName.getText() )){
            firstNameError.setText("First name can only contain letters.");
            success = false;
        }
        else{
            firstNameError.setText("");
            success =true;
        }
        return success;
    }

    public boolean checkLastName(){
        boolean success = false;
        if(!Pattern.matches("^[\\D]+$", inputLastName.getText() )){
            lastNameError.setText("Last name can only contain letters.");
            success = false;
        }
        else{
            lastNameError.setText("");
            success = true;
        }
        return success;
    }

    public boolean checkEmail(){
        boolean success = false;
        if(!Pattern.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", inputEmail.getText() )){
            emailError.setText("Email must start with a letter, and end with 2-4 ch. after the .(dot).");
            success = false;
        }
        else{
            if(!AccountDB.checkEmailDuplicates(inputEmail.getText())){
                emailError.setText("");
                success = true;
            }
            else{
                emailError.setText("Account with that email already exists");
                success = false;
            }

        }
        return success;
    }

    public boolean checkSSN(){
        boolean success = false;
        if(!Pattern.matches("^[\\d]{9}$", inputSSN.getText())){
            SSNError.setText("Social Security Number must contain 9 #'s");
            success = false;
        }
        else{
            SSNError.setText("");
            success = true;
        }
        return success;
    }

    public boolean checkPhoneNumber(){
        boolean success = false;
        if(!Pattern.matches("[\\(]?\\d{3}[\\)]?([-.]?)\\s*\\d{3}\\1\\s*\\d{4}",inputPhoneNumber.getText())){
            phoneNumberError.setText("Enter phone number with the area code 1st. (must be 10 digits)");
            success = false;
        }
        else {
            phoneNumberError.setText("");
            success = true;
        }
        return success;
    }

    public boolean authenticate() {
        //authenticate = check all input
        boolean success = false;
        success = checkUsername();
        success = checkPassword();
        success = checkFirstName();
        success = checkLastName();
        success = checkEmail();
        success = checkSSN();           // STILL NEEDS DUPLICATE CHECKER
        success = checkPhoneNumber();   // STILL NEEDS DUPLICATE CHECKER
        return success;
    }

    public void btnChoosePicAction(ActionEvent event)throws MalformedURLException{
        FileChooser fC = new FileChooser();
        fC.setInitialDirectory(new File("C:\\Users\\Public\\Pictures"));
        File selectedFile = fC.showOpenDialog(null);

        if(selectedFile != null){
            filePathViewer.setText(selectedFile.getAbsolutePath());
            changePicture(selectedFile.getAbsoluteFile());
        }
        else{
            filePathViewer.setText("File is not valid");
        }
    }

    public void changePicture(File selectedFile){
        Image pic = new Image(selectedFile.toURI().toString());
        picture.setImage(pic);
        hasPicChanged = true;

        URI uri = selectedFile.toURI();
        if(hasPicChanged = true){
            try {
                picUrl = uri.toURL();
                System.out.println("URL from URI: " + picUrl);
            }
            catch (MalformedURLException e) {
                System.out.println("Malformed URL: " + e.getMessage());
            }
        }
    }
}
