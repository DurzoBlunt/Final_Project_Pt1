package model;

import java.io.IOException;
import java.util.ArrayList;
import DataStructure.MyMaps;
import DataStructure.MyEntry;

public class AccountDB {
    public static User currentUser = new User();

    //private static ArrayList<User> accountList = new ArrayList<User>();
    private static MyMaps<String, User> accountList = new MyMaps<>();

//    public static ArrayList<User> getAccountList() {
//        return accountList;
//    }
    public static MyMaps<String, User> getAccountList() {
        return accountList;
    }

//    public static void populateList() throws Exception{
//        try{
//            setAccountList((ArrayList<User>) AccountIO.readUsers());
//        } catch (IOException e) {
//            System.err.println("Fail to open/read users.dat file");
//        } catch (ClassNotFoundException e) {
//            System.err.println("Failed to read and cast the AccountDB due to user class issues.");
//        }
//    }
    public static void populateList() throws Exception{
        try{
            setAccountList((MyMaps<String, User>) AccountIO.readUsers());
        } catch (IOException e) {
            System.err.println("Fail to open/read users.dat file");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to read and cast the AccountDB due to user class issues.");
        }
    }

//    public static void setAccountList(ArrayList<User> accountList) {
//        AccountDB.accountList = accountList;
//    }
    public static void setAccountList(MyMaps<String, User> accountList) {
        AccountDB.accountList = accountList;
    }

//    public static void addAccount(User newUser){
//            accountList.add(newUser);
//            setAccountList(accountList);
//
//        try{
//            AccountIO.writeUsers(accountList);
//
//        } catch (IOException e) {
//            System.err.println("Cannot write AccountDB to binary file!");
//            e.printStackTrace();
//        }
//    }
    public static void addAccount(User newUser){
        accountList.put(newUser.getUsername(), newUser);
        setAccountList(accountList);
    
        try{
            AccountIO.writeUsers(accountList);
    
        } catch (IOException e) {
            System.err.println("Cannot write AccountDB to binary file!");
            e.printStackTrace();
        }
    }

//    public static boolean checkAccountExistence(String other){
//        boolean doesExist = false;
//        for(User user:accountList) {
//            if(user.getUsername().equalsIgnoreCase(other)) {
//                doesExist = true;
//                setCurrentUser(user);
//                return doesExist;
//            }
//        }
//        return doesExist;
//    }
    public static boolean checkAccountExistence(String other){
        boolean doesExist = false;
        if (accountList.containsKey(other) == true){
            doesExist = true;
            setCurrentUser(other);
            return doesExist;
        }
        return doesExist;
    }

//    private static void setCurrentUser(User tempUser){              // Clones existing user if applicable.
//        currentUser = new User(tempUser.getfName(), tempUser.getlName(), tempUser.getSsn(), tempUser.getBday(), tempUser.getGender(),
//                tempUser.getUsername(), tempUser.getPassword(), tempUser.getEmail(), tempUser.getPhoneNum(), tempUser.getProfilePic());
//    }
    private static void setCurrentUser(String username){// Clones existing user if applicable.
        User tempUser = accountList.get(username);
        currentUser = new User(tempUser.getfName(), tempUser.getlName(), tempUser.getSsn(), tempUser.getBday(), tempUser.getGender(),
                tempUser.getUsername(), tempUser.getPassword(), tempUser.getEmail(), tempUser.getPhoneNum(), tempUser.getProfilePic());
    }

    public static User getCurrentUser(){
        return currentUser;
    }


//    public static boolean checkEmailDuplicates(String other){
//        boolean hasDuplicate = false;
//        for(User user:accountList)
//        {
//            if(user.getEmail().equalsIgnoreCase(other))
//            {
//                hasDuplicate = true;
//                return hasDuplicate;
//            }
//        }
//        return hasDuplicate;
//    }
    public static boolean checkEmailDuplicates(String other){
        boolean hasDuplicate = false;
        for (String key: accountList.keySet()) {
            if (accountList.get(key).getEmail().equalsIgnoreCase(other)){
                hasDuplicate = true;
                return hasDuplicate;
            }
        }

        return hasDuplicate;
    }
}
