import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class Logging {
    public static void writeInLogFile(String accountType,String transactionType,double currBalance)
    {
        LocalDate date=LocalDate.now();
        LocalTime time=LocalTime.now();
        File file=new File("bank_transaction.txt");

        StringBuilder sb=new StringBuilder();

        sb.append("Transaction Date:"+date+"\n");
        sb.append("Transaction Time:"+time+"\n");
        sb.append("Transaction Account Type:"+accountType+"\n");
        sb.append("Transaction Type:"+transactionType+"\n");
        sb.append("Current Balance:"+currBalance+"\n");
        sb.append("\n"+"\n");
        try
        {
            FileWriter fw=new FileWriter(file,true);
            fw.write(sb.toString());
            fw.flush();
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("Error while writing in the file." + e);
        }

    }
}
