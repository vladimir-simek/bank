package com.vladimirsimek.banking.data;

public class User {
    private String name;
    private int age;
    private String pin;
    private boolean isAdult;
    private Email email;

    public User(String name, int age, String pin, boolean isAdult, Email email) {
        this.name = name;
        this.age = age;
        this.pin = pin;
        this.isAdult = isAdult;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
