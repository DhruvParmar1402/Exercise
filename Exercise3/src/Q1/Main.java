package Q1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int numberOfEmployees;

        Scanner sc=new Scanner(System.in);

        System.out.print("Please enter the number of employee data you want to enter:");
        numberOfEmployees=sc.nextInt();

        System.out.println("=============================================");

        ArrayList<Employee> arr=new ArrayList<>();

        for(int i=0;i<numberOfEmployees;i++)
        {
            System.out.print("Enter the Employee id:");
            int id=sc.nextInt();

            System.out.print("Enter the Employee name:");
            String name=sc.next();

            System.out.print("Enter the Employee department:");
            String depatment=sc.next();

            System.out.print("Enter the Employee salary:");
            double salary=sc.nextDouble();

            System.out.print("Enter the Employee age:");
            int age=sc.nextInt();

            arr.add(new Employee(id,name,depatment,salary,age));
            System.out.println("=============================================");
        }
        List<Employee> SalaryGreaterThan_50000=arr.stream().filter(x-> x.getSalary()>50000).collect(Collectors.toList());
        System.out.print("Employee with salary greater than 500000 is/are:");
        SalaryGreaterThan_50000.forEach(System.out::println);

        System.out.println("=============================================");
        System.out.println("List of distinct are as follows:");
        Util.getUniqueDepartment(arr);


        System.out.println("=============================================");
        System.out.println("Average salary department wise is as follows:");
        Util.getAverageSalary(arr);


        System.out.println("=============================================");
        List<Employee> employeesSortedByAge =Util.getEmployeesSortByAge(arr);
        System.out.println("The youngest employee is :"+employeesSortedByAge.get(0));
        System.out.println("The oldest employee is :"+employeesSortedByAge.get(employeesSortedByAge.size()-1));
    }
}