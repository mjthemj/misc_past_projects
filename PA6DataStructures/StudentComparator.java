

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> { // complete this class
    
    @Override
    public int compare(Student arg1, Student arg2){
        if (arg1.grade != arg2.grade){
            return arg1.grade - arg2.grade;
        }
        else{
           return arg1.name.compareTo(arg2.name);
        }
    }
}
