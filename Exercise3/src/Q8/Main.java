package Q8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of the orders:");
        int order = sc.nextInt();

        System.out.println("=============================================");

        for (int i = 0; i < order; i++) {
            System.out.print("Enter the id number of the Order:");
            int id=sc.nextInt();

            System.out.print("Enter the name of Customer:");
            String customerName=sc.next();

            System.out.print("Enter the amount:");
            double totalAmount=sc.nextDouble();

            System.out.print("Enter the date in DD/MM/YYYY format:");
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date=LocalDate.parse(sc.next(),formatter);

            System.out.print("Enter the status of the Order:");
            String status=sc.next();

            orders.add(new Order(id,customerName,totalAmount,date,status));
            System.out.println("=============================================");
        }

        List<Order> lastSevenDayTransaction=Util.getRecentTransaction(orders);
        System.out.println("Transaction happened in last 7 days are as follows:");
        System.out.println(lastSevenDayTransaction);

        System.out.println("=============================================");
        double sum=Util.getRevenue(orders);
        System.out.println("Total revenue generated till now is:"+sum);

        System.out.println("=============================================");
        System.out.println("Top customers are:");

        Util.gettopCustomers(orders);
    }
}
