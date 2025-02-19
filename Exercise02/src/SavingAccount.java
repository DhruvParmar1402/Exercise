import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String msg){
        super(msg);
    }
}

class ExceedingWithdrawLimitException extends Exception{
    public ExceedingWithdrawLimitException(String msg)
    {
        super(msg);
    }
}

public class SavingAccount extends BankAccount implements Taxable{
    private double initalBalance;
    private int withdrawLimit=20000;
    private String name;
    static List<Transaction> transactionList=new ArrayList<>();
    private final int INTEREST_RATE=4;

    public SavingAccount(int initalBalance, String name) {
        this.initalBalance = initalBalance;
        this.name = name;
    }

    @Override
    public String deposit(int amount)
    {
        this.initalBalance +=amount;
        StringBuilder sb=new StringBuilder();
        sb.append("Rupees " + amount + " credited successfully to "+ name +"'s account\n");
        sb.append(name+"'s new Balance is:"+ initalBalance+"\n");
        Logging.writeInLogFile("Saving Account","Deposited "+amount + "rs",initalBalance);

        transactionList.add(new Transaction( this.name,amount,"Withdraw","Saving"));

        return sb.toString()+"\n";
    }

    @Override
    public String withdraw (int ammountToWithdraw)
    {
        if(ammountToWithdraw>this.initalBalance) {
            try {
                throw new InsufficientBalanceException("Insufficient balance please enter the amount carefully.\n");
            } catch (InsufficientBalanceException e)
            {
                return e.toString();
            }
        }
        if(ammountToWithdraw > withdrawLimit)
        {
            try {
                throw new ExceedingWithdrawLimitException("Entered amount exceeds the withdraw limit ,please enter properly.\n");
            } catch (ExceedingWithdrawLimitException e)
            {
                return e.toString();
            }
        }
        this.initalBalance -=ammountToWithdraw;
        StringBuilder sb=new StringBuilder();
        sb.append("Rupees "+ ammountToWithdraw +" debited successfully from "+name+"'s account\n");
        sb.append(name+"'s new Balance is:"+ initalBalance+"\n");

        Logging.writeInLogFile("Saving Account","Withdrawn "+ammountToWithdraw + "rs",initalBalance);
        transactionList.add(new Transaction( this.name,ammountToWithdraw,"Withdraw","Saving"));
        return sb.toString()+"\n";
    }

    public String checkBalance()
    {
        return name+"'s saving account Balance is:" + initalBalance +"rs"+"\n";
    }

    @Override
    public double calculateIntrest() {
        return (initalBalance * INTEREST_RATE * 10) / 100;
    }

    @Override
    public double deductTax(){
        double tax = 0;

        if (initalBalance <= 1200000) {
            tax = 0;
        } else if (initalBalance <= 2400000) {
            tax = (initalBalance - 1200000) * 0.10;
        } else {
            tax = (initalBalance - 2400000) * 0.20 + 120000;
        }

        return tax;
    }

    public static List<Transaction> getTopTransactionList(){
        List<Transaction> topTransaction =transactionList.stream().filter((x)->x.getAmount()>=5000).collect(Collectors.toList());
        return topTransaction;
    }
}
