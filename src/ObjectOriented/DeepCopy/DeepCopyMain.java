package DeepCopy;

public class DeepCopyMain {

	public static void main(String[] args) {
		Course course = new Course("Maths", "physics", "biology");
		Student student1 = new Student("sandeep", "123", course);
		Student student2 = null;
		
		try {
			student2 = (Student) student1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(student1.course.sub3);
		System.out.println(student2.course.sub3);
		student1.course.sub3 = "chemistry";
		System.out.println("----------------------");
		System.out.println(student1.course.sub3);
		System.out.println(student2.course.sub3);
		

	}

}
