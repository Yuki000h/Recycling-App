package com.example.recyclingapp;

public class HelperClass {

    public static String SENT_BY_ME = "me";
    public static String SENT_BY_BOT = "bot";

    String name, email, phone, password, conpassword, message, sendby;

    public HelperClass(String message, String sendby) {
        this.message = message;
        this.sendby = sendby;
    }

    public HelperClass(String name, String email, String phone, String password, String conpassword) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.conpassword = conpassword;
    }

    public HelperClass() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendby() {
        return sendby;
    }

    public void setSendby(String sendby) {
        this.sendby = sendby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConpassword() {
        return conpassword;
    }

    public void setConpassword(String conpassword) {
        this.conpassword = conpassword;
    }
}
