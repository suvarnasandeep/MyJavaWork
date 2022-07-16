package LamdaExpression;

public class Employee {

	private String empName;
	private String dept;
	private int salary;
	
	public Employee(String name, String dept, int sal) {
		this.empName = name;
		this.dept = dept;
		this.salary = sal;
	}
	
	public String toString() {
		return "name = " + empName + " | dept = "+ dept + " | salary = " + salary;
	}
	
	public String getName() {
		return empName;
	}
	
	public String getDept() {
		return dept;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setName(String name) {
		
	}
	
}
