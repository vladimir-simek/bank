package com.vladimirsimek.banking.data;

public class BankAccount {
    private int BankCode;
    private int AccountCode;
    private User user;
    private int balance;
    private boolean hasCard;

    public BankAccount(int bankCode, int accountCode, User user, int balance, boolean hasCard, Bank bank) {
        bank.getAccounts().add(accountCode);
        this.BankCode = bankCode;
        this.AccountCode = accountCode;
        this.user = user;
        this.balance = balance;
        this.hasCard = hasCard;
        bank.getAccountsFull().add(this);
    }

    public int getBankCode() {
        return BankCode;
    }

    public void setBankCode(int bankCode) {
        BankCode = bankCode;
    }

    public int getAccountCode() {
        return AccountCode;
    }

    public void setAccountCode(int accountCode) {
        AccountCode = accountCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isHasCard() {
        return hasCard;
    }

    public void setHasCard(boolean hasCard) {
        this.hasCard = hasCard;
    }

    public void addMoney(int amount) {
        this.balance += amount;
    }

    public void removeMoney(int amount) {
        this.balance -= amount;
    }

    public void withdraw(int amount) {
        if (getBalance() - amount < 0) {
            System.out.println("You dont have enough money...");
        } else {
            System.out.println("You've just withdrawn " + amount + "Kč");
            setBalance(this.balance - amount);
        }
    }
}
