
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
	
	public char name;
	public int grade;

	public Student(char arg0, int arg1) {
		this.name = arg0;
		this.grade = arg1;
	}

	public String toString() {
		return String.format("(%c, %d)", name, grade);
	}
}

class SortStudentsByName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.name - o2.name;
	}
}

class SortStudentsByGrade implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.grade - o2.grade;
	}

}

public class StudentSorter {

	public static char[] names = { 'E', 'A', 'Z', 'F', 'R', 'T', 'A', 'C', 'P' };
	public static int[] grades = { 97, 45, 83, 77, 88, 76, 89, 91, 20, };

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		for (int i = 0; i < names.length; i++)
			students.add(new Student(names[i], grades[i]));

		System.out.println("Original:        " + students);
		Collections.sort(students, new SortStudentsByName());
		System.out.println("Sorted by name:  " + students);
		Collections.sort(students, new SortStudentsByGrade());
		System.out.println("Sorted by grade: " + students);

	}
}
