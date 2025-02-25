package Q4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Util {
    public static void decendSortByMarks(ArrayList<Students> listOfStudents)
    {
        Collections.sort(listOfStudents,new StudentComparator().reversed());
    }

    public static void sortByName(ArrayList<Students> listOfStudents){
        Comparator<Students> comparator=Comparator.comparing(Students::getName);
        Collections.sort(listOfStudents,comparator);
    }

    public static Comparator<Students> sortByMarks(){
        return new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                if(o1.getMarks()==o2.getMarks())
                {
                    return 0;
                }
                else if(o1.getMarks()<o2.getMarks())
                {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
    }
}
