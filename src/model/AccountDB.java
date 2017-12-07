package model;

import DataStructure.MyHashMap;

import java.io.IOException;

public class AccountDB {
    //creates user for the current user
    public static User currentUser = new User();

    private static MyHashMap<String, User> accountList = new MyHashMap<>();

    public static MyHashMap<String, User> getAccountList() {
        return accountList;
    }

    public static void populateList() throws Exception{
        try{
            if (AccountIO.readUsers() instanceof MyHashMap) {
                setAccountList((MyHashMap<String, User>) AccountIO.readUsers());
            }
        } catch (IOException e) {
            System.err.println("Fail to open/read users.dat file");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to read and cast the AccountDB due to user class issues.");
        }
    }

    private static void setAccountList(MyHashMap<String, User> accountList) {
        AccountDB.accountList = accountList;
    }

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

    public static boolean checkAccountExistence(String other){
        boolean doesExist = false;
        if (accountList.containsKey(other)){
            doesExist = true;
            setCurrentUser(other);
        }
        return doesExist;
    }

    private static void setCurrentUser(String username){// Clones existing user if applicable.
        User tempUser = accountList.get(username);
        currentUser = new User(tempUser.getfName(), tempUser.getlName(), tempUser.getSsn(), tempUser.getBday(), tempUser.getGender(),
                tempUser.getUsername(), tempUser.getPassword(), tempUser.getEmail(), tempUser.getPhoneNum(), tempUser.getProfilePic());

    }

    public static User getCurrentUser(){
        return currentUser;
    }

    public static boolean checkEmailDuplicates(String other){
        boolean hasDuplicate = false;
        for (String key: accountList.keySet()) {
            if (accountList.get(key).getEmail().equalsIgnoreCase(other)){
                hasDuplicate = true;
            }
        }
        return hasDuplicate;
    }
}
