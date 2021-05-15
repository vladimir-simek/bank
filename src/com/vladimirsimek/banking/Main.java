package com.vladimirsimek.banking;

import com.vladimirsimek.banking.cli.Cli;
import com.vladimirsimek.banking.data.Bank;
import com.vladimirsimek.banking.logic.Logic;

public class Main {

    public static void main(String[] args) {
        new Bank("VladBank", 7030);
        new Bank("Bank for GAYS", 6666);
        Cli.init();
        Cli.welcome();
        Logic.createRandoms();
        Logic.mainAppLoop();

    }
}
