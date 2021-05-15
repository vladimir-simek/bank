package com.vladimirsimek.banking.data;

import com.vladimirsimek.banking.logic.Logic;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Integer> accounts;
    public ArrayList<BankAccount> accountsFull;
    private int bankCode;

    public Bank(String name, int bankCode) {
        this.name = name;
        this.bankCode = bankCode;
        this.accounts = new ArrayList<>();
        this.accountsFull = new ArrayList<>();
        Logic.getBanks().add(this);
    }

    public ArrayList<BankAccount> getAccountsFull() {
        return accountsFull;
    }

    public ArrayList<Integer> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Integer> accounts) {
        this.accounts = accounts;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
