package ShallowCopy;

public class Students implements Cloneable{

	String name;
	String id;
	Course course;
	
	public Students(String name, String id, Course course) {
		this.name = name;
		this.id = id;
		this.course = course;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
