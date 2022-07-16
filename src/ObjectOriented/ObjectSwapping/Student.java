package ObjectSwapping;

public class Student {
	String name;
	int id;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void print() {
		System.out.println("name = " + name + " id = " + id);
	}
}
