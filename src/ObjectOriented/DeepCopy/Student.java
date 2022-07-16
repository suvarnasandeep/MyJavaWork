package DeepCopy;

public class Student implements Cloneable{
	String name, id;
	Course course;
	
	public Student(String name, String id, Course course) {
		this.name = name;
		this.id = id;
		this.course = course;
	}
	
	protected Student clone() throws CloneNotSupportedException {
		Student student = (Student) super.clone();
		student.course = (Course) course.clone();
		return student;
	}
}
