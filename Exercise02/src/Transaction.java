import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private String name;
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private String transactionAccountType;
    private String transactionType;
    private int amount;

    public Transaction(String name, int amount, String transactionType, String transactionAccountType) {
        this.transactionDate=LocalDate.now();
        this.transactionTime=LocalTime.now();
        this.name = name;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionAccountType = transactionAccountType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "name='" + name + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionTime=" + transactionTime +
                ", transactionAccountType='" + transactionAccountType + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                '}';
    }
}

