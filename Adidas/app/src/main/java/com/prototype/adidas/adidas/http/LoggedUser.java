package com.prototype.adidas.adidas.http;

public class LoggedUser {

    private static User ourInstance = new User();
    private static boolean validated = false;

    public static User getInstance() {
        return ourInstance;
    }

    private LoggedUser() {}

    public void setValidated(boolean validated) {this.validated = validated;}
    public boolean getBalidated() {return validated;}
    public static void setUser(User user) {ourInstance = user;}


}
