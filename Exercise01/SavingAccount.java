package org.CoreJavaExercise14Feb;

public class SavingAccount implements BankingService{
    private int initalBalance;
    private int withdrawLimit;
    private String name;

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
        sb.append(name+"'s new Balance is:"+ initalBalance);
        return sb.toString()+"\n";
    }

    @Override
    public String withdraw (int ammountToWithdraw)
    {
        if(ammountToWithdraw>this.initalBalance)
        {
            return "Debit amount exceeds the Balance please enter the valid ammount."+"\n";
        }
        if(ammountToWithdraw > withdrawLimit)
        {
            return "The ammount entered exceeds the withdraw limit, please try again."+"\n";
        }
        this.initalBalance -=ammountToWithdraw;
        StringBuilder sb=new StringBuilder();
        sb.append("Rupees "+ ammountToWithdraw +" debited successfully from "+name+"'s account\n");
        sb.append(name+"'s new Balance is:"+ initalBalance);
        return sb.toString()+"\n";
    }

    @Override
    public String checkBalance()
    {
        return name+"'s saving account Balance is:" + initalBalance +"rs"+"\n";
    }
}
