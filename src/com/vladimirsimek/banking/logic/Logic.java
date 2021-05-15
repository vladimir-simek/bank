package com.vladimirsimek.banking.logic;

import com.vladimirsimek.banking.cli.Cli;
import com.vladimirsimek.banking.data.Bank;
import com.vladimirsimek.banking.data.BankAccount;
import com.vladimirsimek.banking.data.Email;
import com.vladimirsimek.banking.data.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    private static ArrayList<Email> emails = new ArrayList<>();
    private static ArrayList<Bank> banks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static ArrayList<Email> getEmails() {
        return emails;
    }

    public static ArrayList<Bank> getBanks() {
        return banks;
    }

    public static int generateNewBankCode() {
        return (int)((Math.random() * (999999999 - 100000000)) + 100000000);
    }

    public static void mainAppLoop() {
        while (true) {
            Cli.printBankState();
            String mainMenuChoice = Cli.printMainMenu();
            if (mainMenuChoice.equals("A")) {
                banks.get(0).getAccountsFull().get(0).addMoney(50);
            } else if (mainMenuChoice.equals("B")) {
                Cli.listAllBankAccountsInBankID(0,0);
            } else if (mainMenuChoice.equals("C")) {
                Cli.listAllBankAccountsInBankID(0, 1);
            } else if (mainMenuChoice.equals("D")) {
                banks.get(0).getAccountsFull().get(0).withdraw(Cli.printMoneyChoose());
            } else if (mainMenuChoice.equals("E")) {
                System.out.println("You've just deleted your account...");
                System.out.println("You don't have any other accounts, logging off...");
                System.exit(0);
            } else if (mainMenuChoice.equals("F")) {
                System.out.println("Goodbye.");
                System.exit(0);
            }
        }
    }

    public static void createRandoms() {
        Email idiot = new Email("idiot", "dumb.idiot", "admin1234");
        User idiot1 = new User("Idiot", 16, "856314/7946", false, idiot);
        new BankAccount(7030, Logic.generateNewBankCode(), idiot1, 5000, false, banks.get(0));
        Email steve = new Email("steve", "mine.craft", "noob45");
        User steve1 = new User("Steve", 98, "648219/9237", true, steve);
        new BankAccount(7030, Logic.generateNewBankCode(), steve1, 50, false, banks.get(0));
        Email julie = new Email("julie", "vladimirsimek.com", "Julie2005");
        User julie1 = new User("Julie Reichenbachová", 15, "856314/7946", false, julie);
        new BankAccount(7030, Logic.generateNewBankCode(), julie1, 25000, true, banks.get(0));
    }

}
