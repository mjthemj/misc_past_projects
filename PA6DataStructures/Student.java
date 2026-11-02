

public class Student {

	public String name;
	public int grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public String toString() {
		return String.format("(%s, %d)", name, grade);
	}
}
