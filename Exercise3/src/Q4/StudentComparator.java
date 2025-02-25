package Q4;

import java.util.Comparator;

public class StudentComparator implements Comparator<Students> {
    public int compare(Students s1,Students s2)
    {
        if(s1.getMarks()==s2.getMarks())
        {
            return 0;
        }
        else if(s1.getMarks()<s2.getMarks())
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }

}
