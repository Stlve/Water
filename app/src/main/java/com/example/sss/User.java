package com.example.sss;

public class User {
    String token;
    int playid;
    public static User currentUser = new User();
    public static void setUser(String token,int playid) {
        currentUser.token = token;
        currentUser.playid= playid;
    }
    public static User getUser(){
        return currentUser;
    }
}
