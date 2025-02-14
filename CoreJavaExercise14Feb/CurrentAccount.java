package org.CoreJavaExercise14Feb;

public class CurrentAccount implements BankingService{
    private int initalBalance =10000;
    private int overDraft=5000;
    private String name;

    public CurrentAccount(int initalBalance, String name) {
        this.initalBalance = initalBalance;
        this.name = name;
    }

    @Override
    public String deposit(int amount)
    {
        this.initalBalance +=amount;
        StringBuilder sb=new StringBuilder();
        sb.append("Rupees " + amount + " credited successfully to "+name+"'s account");
        sb.append(name+"'s new Balance is:"+ initalBalance);
        return sb.toString()+"\n";
    }

    @Override
    public String withdraw (int ammountToWithdraw)
    {
        if(ammountToWithdraw> initalBalance)
        {
            if(ammountToWithdraw- initalBalance > overDraft)
            {
                return "Bank ke pass bhi itne paise nahi hai."+"\n";
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
        sb.append(name+"'s new Balance is:"+ initalBalance);
        return sb.toString()+"\n";
    }

    @Override
    public String checkBalance()
    {
        if(initalBalance<0)
        {
            return "You need to repay rupees "+initalBalance*(-1)+" to the bank ,so please hurry up.";
        }
        return name+"'s current Balance is:" + initalBalance +"rs"+"\n";
    }
}
