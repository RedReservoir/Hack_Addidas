package com.prototype.adidas.adidas.http;

public class User_VIP extends User {

    private String dni;
    private Bracelet nfc_code;

    public User_VIP(String id_user, String email, String passwd, String name, String surname, String dni, Bracelet nfc_code) {
        super(id_user, email, passwd, name, surname);
        this.dni = dni;
        this.nfc_code = nfc_code;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
/*
    public String getNfc_code() {
        return nfc_code;
    }

    public void setNfc_code(String nfc_code) {
        this.nfc_code = nfc_code;
    }
    */
}
