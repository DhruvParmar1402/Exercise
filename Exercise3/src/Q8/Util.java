package Q8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {
    public static List<Order> getRecentTransaction(List<Order> list)
    {
        List<Order> recentTransaction=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,-7);
        LocalDate previousdate=LocalDate.now().minus(7, ChronoUnit.DAYS);
        LocalDate currentDate=LocalDate.now();

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getOrderDate().isBefore(currentDate) && list.get(i).getOrderDate().isAfter(previousdate))
            {
                recentTransaction.add(list.get(i));
            }
        }
        return recentTransaction;
    }
    public static double getRevenue(List<Order> orders)
    {
        List<Order> revenueList = orders.stream().filter((x)-> x.getStatus().equals("Completed")).collect(Collectors.toList());
        double sum=0;
        for (Order odr:revenueList)
        {
            sum+=odr.getTotalAmount();
        }
        return sum;
    }
    public static void gettopCustomers(List<Order>orders)
    {
        Map<String , Double> topCustomers=orders.stream().collect(Collectors.groupingBy(Order::getCustomerName,Collectors.summingDouble(Order::getTotalAmount)));
        topCustomers= topCustomers.entrySet().stream().filter((x)->x.getValue()>5000).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for(Map.Entry<String, Double> entry : topCustomers.entrySet())
        {
            System.out.println(entry.getKey());
        }
    }
}
