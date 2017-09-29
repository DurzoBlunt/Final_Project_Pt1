package model;

import java.io.IOException;
import java.util.ArrayList;

public class AccountDB {
    public static User currentUser = new User();

    private static ArrayList<User> accountList = new ArrayList<User>();

    public static ArrayList<User> getAccountList() {
        return accountList;
    }

    public static void populateList() throws Exception{
        try{
            setAccountList((ArrayList<User>) AccountIO.readUsers());
        } catch (IOException e) {
            System.err.println("Fail to open/read users.dat file");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to read and cast the AccountDB due to user class issues.");
        }
    }

    public static void setAccountList(ArrayList<User> accountList) {
        AccountDB.accountList = accountList;
    }

    public static void addAccount(User newUser){
            accountList.add(newUser);
            setAccountList(accountList);

        try{
            AccountIO.writeUsers(accountList);

        } catch (IOException e) {
            System.err.println("Cannot write AccountDB to binary file!");
            e.printStackTrace();
        }
    }

    public static boolean checkAccountExistence(String other){
        boolean doesExist = false;
        for(User user:accountList) {
            if(user.getUsername().equalsIgnoreCase(other)) {
                doesExist = true;
                setCurrentUser(user); // Clones existing user if applicable.
                return doesExist;
            }
        }
        return doesExist;
    }

    private static void setCurrentUser(User tempUser){
       currentUser = new User(tempUser.getfName(), tempUser.getlName(), tempUser.getSsn(), tempUser.getBday(), tempUser.getGender(),
                tempUser.getUsername(), tempUser.getPassword(), tempUser.getEmail(), tempUser.getPhoneNum(), tempUser.getProfilePic());
    }

    public static User getCurrentUser(){
        return currentUser;
    }


    public static boolean checkEmailDuplicates(String other){
        boolean hasDuplicate = false;
        for(User user:accountList)
        {
            if(user.getEmail().equalsIgnoreCase(other))
            {
                hasDuplicate = true;
                return hasDuplicate;
            }
        }
        return hasDuplicate;
    }
}
