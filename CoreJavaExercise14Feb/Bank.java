package org.CoreJavaExercise14Feb;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public static void main(String[] args) {

        Map<String,BankingService> accounts=new HashMap<>();

        accounts.put("Dhruv Parmar",new SavingAccount(20000,"Dhruv Parmar"));
        accounts.put("Jeevan Rajpurohit",new CurrentAccount(20000,"Jeevan Rajpurohit"));

        BankingService dhruvAccount=accounts.get("Dhruv Parmar");
        BankingService jeevanAccount=accounts.get("Jeevan Rajpurohit");

        System.out.println(dhruvAccount.withdraw(1000));
        System.out.println(dhruvAccount.deposit(9000));
        System.out.println(dhruvAccount.checkBalance());

        System.out.println(jeevanAccount.withdraw(15000));
        System.out.println(jeevanAccount.deposit(16000));
        System.out.println(jeevanAccount.checkBalance());
    }
}
