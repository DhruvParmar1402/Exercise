package Q1;

import java.util.*;
import java.util.stream.Collectors;

public class Util {
    public static void getAverageSalary (ArrayList<Employee>arr)
    {
        Map<String, Double> map =arr.stream().collect(Collectors.groupingBy(e -> e.getDepartment(),Collectors.averagingDouble(e -> e.getSalary())));
        for(Map.Entry<String , Double> values:map.entrySet())
        {
            System.out.println("Department are:"+values.getKey());
            System.out.println("Average is :"+values.getValue());
        }
    }
    public static void getUniqueDepartment(ArrayList<Employee>arr)
    {
        HashSet<String> uniqueDepartment=new HashSet<>();
        arr.stream().forEach(x -> uniqueDepartment.add(x.getDepartment()));
        System.out.println(uniqueDepartment);
    }

    public static ArrayList<Employee> getEmployeesSortByAge(ArrayList<Employee>arr)
    {
        Collections.sort(arr,(x,y)-> x.getAge()-y.getAge());
        return arr;
    }
}
