package Q4;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int numberOfStudents;
        ArrayList<Students>listOfStudents=new ArrayList<>();

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the numer of Students:");
        numberOfStudents=sc.nextInt();
        System.out.println("=============================================");

        for(int i=0;i<numberOfStudents;i++)
        {
            int id;
            String name;
            double marks;

            System.out.print("Enter the Id number:");
            id=sc.nextInt();

            System.out.print("Enter the name:");
            name=sc.next();

            System.out.print("Enter the marks:");
            marks=sc.nextDouble();

            listOfStudents.add(new Students(id,name,marks));
            System.out.println("=============================================");
        }

        Util.decendSortByMarks(listOfStudents);
        System.out.println("The Students sorted in decending order are as follows:");
        System.out.println(listOfStudents);

        System.out.println("=============================================");
        Util.sortByName(listOfStudents);
        System.out.println("The Students sorted according to name are as follows:");
        System.out.println(listOfStudents);

        System.out.println("=============================================");
        System.out.println("The Student with top 3 marks are as follows:");
        List<Students> sortedByMarks=listOfStudents.stream().sorted(Util.sortByMarks()).limit(3).collect(Collectors.toList());
        System.out.println(sortedByMarks);
    }
}
