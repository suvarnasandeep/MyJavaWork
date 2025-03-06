package DataStructureAlgorithm.HashMap;

public class Employee {

	String name;
	
	public Employee(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	/*public int hashCode() {
		return (this.name == null ? 0 : this.name.hashCode());
	}*/
	
}
