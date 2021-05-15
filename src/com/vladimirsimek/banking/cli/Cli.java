package com.vladimirsimek.banking.cli;

import com.sun.source.tree.IfTree;
import com.vladimirsimek.banking.data.BankAccount;
import com.vladimirsimek.banking.data.Email;
import com.vladimirsimek.banking.data.User;
import com.vladimirsimek.banking.logic.Logic;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Scanner;

public class Cli {

    private static Scanner sc;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void welcome() {
        printLine();
        System.out.println("""
                ██████╗  █████╗ ███╗   ██╗██╗  ██╗██╗███╗   ██╗ ██████╗      █████╗ ██████╗ ██████╗\s
                ██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝██║████╗  ██║██╔════╝     ██╔══██╗██╔══██╗██╔══██╗
                ██████╔╝███████║██╔██╗ ██║█████╔╝ ██║██╔██╗ ██║██║  ███╗    ███████║██████╔╝██████╔╝
                ██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ ██║██║╚██╗██║██║   ██║    ██╔══██║██╔═══╝ ██╔═══╝\s
                ██████╔╝██║  ██║██║ ╚████║██║  ██╗██║██║ ╚████║╚██████╔╝    ██║  ██║██║     ██║    \s
                ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝     ╚═╝  ╚═╝╚═╝     ╚═╝    \s""");
        printLine();
        System.out.println("Welcome to Vladimirs banking app. What are you up to?");
        System.out.println("A) Create an account");
        System.out.println("B) Login to an account");
        System.out.println("C) Die");
        String choice = sc.nextLine();
        choice = choice.toUpperCase(Locale.ROOT);
        switch (choice) {
            case "A" -> createAnAccount();
            case "B" -> System.out.println("You just speed-ran life, gg.");
            default -> throw new IllegalArgumentException("ARE YOU AN IDIOT? now die.");
        }

    }

    public static void loginToAnAccount() {
        System.out.println("You don't have an account lol");
    }

    public static void createAnEmail() {
        String name = "name";
        String domain = "domain";
        String password = "password";

        System.out.println("What name would you like to choose for your email?");
        System.out.println("(name@example.com)");
        name = sc.nextLine();
        System.out.println("What domain would you like to choose for your email?");
        System.out.println("(domain example: vladimirsimek.com)");
        domain = sc.nextLine();
        System.out.println("Choose your password:");
        password = sc.nextLine();

        Email newEmail = new Email(name, domain, password);
    }

    public static void createAnUser() {
        String name = "name";
        int age = 0;
        String pin = "000000/0000";
        boolean isAdult = false;
        String emailRaw = "mail@mail.mail";
        String password = "password";

        System.out.println("What is your name?");
        System.out.println("(Example: Vladimír Šimek)");
        name = sc.nextLine();

        System.out.println("How old are you?");
        age = Integer.parseInt(sc.nextLine());

        System.out.println("What is your personal identification number?");
        System.out.println("(Example: 123456/1234)");
        pin = sc.nextLine();

        if (age >= 18) isAdult = true;

        System.out.println("What is your email?");
        System.out.println("(Example: name@your.domain)");
        emailRaw = sc.nextLine();

        boolean isTrue = false;

        for (int i = 0; i < Logic.getEmails().size(); i++) {
            if (emailRaw.equals(Logic.getEmails().get(i).getEmail())) {
                System.out.println("What is your password?");
                password = sc.nextLine();
                if (password.equals(Logic.getEmails().get(i).getPassword())) {
                    System.out.println("Right password.");
                    System.out.println("Which bank would you like to choose?");
                    System.out.println("vladBank is the only option, it's the best bank ever, so go along with it.");
                    isTrue = true;
                    Email email = Logic.getEmails().get(i);
                    User newUser = new User(name, age, pin, isAdult, email);
                    BankAccount newBankAccount = new BankAccount(Logic.getBanks().get(0).getBankCode(), Logic.generateNewBankCode(), newUser, 0, false, Logic.getBanks().get(0));
                } else throw new IllegalArgumentException("Wrong password. Now die.");
            }
        }

        if (!isTrue) throw new IllegalArgumentException("Are you an retard?");
    }

    public static void createAnAccount() {
        createAnEmail();
        createAnUser();
    }

    public static void printLine() {
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public static void printBankState() {
        printLine();
        System.out.println(Logic.getBanks().get(0).getAccountsFull().get(0).getUser().getName());
        System.out.println(Logic.getBanks().get(0).getAccountsFull().get(0).getAccountCode() + "/" + Logic.getBanks().get(0).getAccountsFull().get(0).getBankCode());
        System.out.println("Your balance: " + Logic.getBanks().get(0).getAccountsFull().get(0).getBalance() + "Kč");
        printLine();
    }

    public static @NotNull
    String printMainMenu() {
        System.out.println("A) Get free 50Kč");
        System.out.println("B) Send money");
        System.out.println("C) Steal money");
        System.out.println("D) Withdraw money");
        System.out.println("E) Delete my account");
        System.out.println("F) Exit");

        return sc.nextLine().toUpperCase(Locale.ROOT);
    }

    public static int printMoneyChoose() {
        Cli.printLine();
        System.out.println("How much would you like to withdraw?");
        return Integer.parseInt(sc.nextLine());
    }

    public static void listAllBankAccountsInBankID(int id, int move) {
        int accounts = 0;
        for (int i = 1; i < Logic.getBanks().get(id).getAccountsFull().size(); i++) {
            System.out.println(i + ") " + Logic.getBanks().get(id).getAccountsFull().get(i).getAccountCode() + "/" + Logic.getBanks().get(id).getAccountsFull().get(i).getBankCode());
            accounts = i;
        }


        if (move == 0) {
            System.out.println("To which account you would like to send money?");
            System.out.println("You can send up to " + Logic.getBanks().get(id).getAccountsFull().get(0).getBalance() + "Kč");

            int choice = Integer.parseInt(sc.nextLine());
            if (choice <= 0 || choice > accounts) {
                System.out.println("Are you dumb?");
            } else {
                System.out.println("How much would you like to send?");
                int amount = Integer.parseInt(sc.nextLine());
                if (Logic.getBanks().get(id).getAccountsFull().get(0).getBalance() - amount < 0) {
                    System.out.println("No dude, you are broke...");
                } else {
                    Logic.getBanks().get(id).getAccountsFull().get(choice).addMoney(amount);
                    Logic.getBanks().get(id).getAccountsFull().get(0).removeMoney(amount);
                }
            }
        } else {
            System.out.println("From which account you would like to steal money?");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice <= 0 || choice > accounts) {
                System.out.println("Are you dumb?");
            } else {
                System.out.println("How much would you like to steal?");
                System.out.println("You can steal up to " + Logic.getBanks().get(id).getAccountsFull().get(choice).getBalance() + "Kč");
                int amount = Integer.parseInt(sc.nextLine());
                if (Logic.getBanks().get(id).getAccountsFull().get(choice).getBalance() - amount < 0) {
                    System.out.println("No dude, he is broke...");
                } else {
                    Logic.getBanks().get(id).getAccountsFull().get(choice).removeMoney(amount);
                    Logic.getBanks().get(id).getAccountsFull().get(0).addMoney(amount);
                }
            }
        }
    }
}

