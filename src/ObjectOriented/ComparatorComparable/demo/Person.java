package ComparatorComparable.demo;

public class Person implements Comparable<Person>{

	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + " "  + age ;
	}
	
	public int compareTo(Person o) {
		int cmp = this.getFirstName().compareTo(o.getFirstName());
		return cmp != 0 ? cmp : this.getLastName().compareTo(o.getLastName());
	}
	
	
	
}
