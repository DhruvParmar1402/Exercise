import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bank {
    public static void main(String[] args) {
        var dhruvAcc=new SavingAccount(1200001,"Dhruv");
        var jeevanAcc=new CurrentAccount(1300000,"Jeevan");

        System.out.println(dhruvAcc.deposit(20000));
        System.out.println(dhruvAcc.withdraw(30001));
        System.out.println(dhruvAcc.withdraw(20001));
        System.out.println(dhruvAcc.withdraw(20000));
        System.out.println(dhruvAcc.calculateIntrest());
        System.out.println(dhruvAcc.checkBalance());
        System.out.println("Tax is :"+dhruvAcc.deductTax());

        System.out.println(jeevanAcc.deposit(20000));
        System.out.println(jeevanAcc.withdraw(30001));
        System.out.println(jeevanAcc.withdraw(20001));
        System.out.println(jeevanAcc.deposit(20000));
        System.out.println(jeevanAcc.withdraw(100));
        System.out.println(jeevanAcc.calculateIntrest());
        System.out.println(jeevanAcc.checkBalance());
        System.out.println("Tax is:"+jeevanAcc.deductTax());

        System.out.println(SavingAccount.getTopTransactionList().toString());
        System.out.println(CurrentAccount.getTopTransactionList().toString());
    }
}
