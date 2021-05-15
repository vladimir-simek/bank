package com.vladimirsimek.banking.data;

import com.vladimirsimek.banking.logic.Logic;

import java.util.Date;

public class Email {
    private final String name;
    private final String domain;
    private String password;

    public Email(String name, String domain, String password) {
        this.name = name;
        this.domain = domain;
        this.password = password;
        Logic.getEmails().add(this);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getEmail() {
        return getName() + "@" + getDomain();
    }
}
