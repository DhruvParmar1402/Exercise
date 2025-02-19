import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class InvalidTransactionException extends Exception{
    public InvalidTransactionException (String msg)
    {
        super(msg);
    }
}

public class CurrentAccount extends BankAccount implements Taxable{
    private double initalBalance;
    private int overDraft=5000;
    private String name;
    static List<Transaction> transactionList=new ArrayList<>();
    private final int INTEREST_RATE=2;

    public CurrentAccount(int initalBalance, String name) {
        this.initalBalance = initalBalance;
        this.name = name;
    }

    @Override
    public String deposit(int amount)
    {
        this.initalBalance +=amount;
        StringBuilder sb=new StringBuilder();
        sb.append("Rupees " + amount + " credited successfully to "+name+"'s account\n");
        sb.append(name+"'s new Balance is:"+ initalBalance +"\n");
        Logging.writeInLogFile("Current Account","Deposited "+amount + "rs",initalBalance);
        transactionList.add(new Transaction( this.name,amount,"Deposit","Current"));
        return sb.toString()+"\n";
    }

    @Override
    public String withdraw (int ammountToWithdraw)
    {
        if(-1*initalBalance<overDraft && initalBalance<0)
        {
            try{
                throw new InvalidTransactionException("You cannot withdraw above the overdrawn limit.\n");
            }
            catch (InvalidTransactionException e)
            {
                return e.toString();
            }
        }
        if(ammountToWithdraw> initalBalance)
        {
            if(ammountToWithdraw- initalBalance > overDraft)
            {
                try{
                    throw new ExceedingWithdrawLimitException("The amount exceeds the over draft limit, please try again.\n");
                }
                catch (ExceedingWithdrawLimitException e)
                {
                    return e.toString();
                }
            }
            else {
                this.initalBalance -=ammountToWithdraw;
            }
        }
        else
        {
            this.initalBalance -=ammountToWithdraw;
        }
        StringBuilder sb=new StringBuilder();
        sb.append("Rupees "+ ammountToWithdraw +" debited successfully from "+name+"'s account\n");
        sb.append(name+"'s new Balance is:"+ initalBalance+"\n");

        Logging.writeInLogFile("Current Account","Withdrawn "+ammountToWithdraw + "rs",initalBalance);
        transactionList.add(new Transaction( this.name,ammountToWithdraw,"Withdraw","Current"));

        return sb.toString()+"\n";
    }

    public String checkBalance()
    {
        if(initalBalance<0)
        {
            return "You need to repay rupees "+initalBalance*(-1)+" to the bank ,so please hurry up.";
        }
        return name+"'s current Balance is:" + initalBalance +"rs"+"\n";
    }

    @Override
    public double calculateIntrest() {
        return (initalBalance * INTEREST_RATE * 10) / 100;
    }

    @Override
    public double deductTax()
    {
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
