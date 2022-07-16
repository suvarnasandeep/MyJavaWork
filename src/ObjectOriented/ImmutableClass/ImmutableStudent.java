package ImmutableClass;

public final class ImmutableStudent {

	private final String name;
	private final StudentAge age;

	public ImmutableStudent(String name, StudentAge age) {		
		this.name = name;
		
		StudentAge cloneAge = new StudentAge(age.getDate(), age.getMonth(), age.getYear());
		this.age = cloneAge;
	}

	public String getName() {
		return name;
	}

	public StudentAge getAge() {
		StudentAge cloneAge = new StudentAge(this.age.getDate(), this.age.getMonth(), this.age.getYear());
		return cloneAge;
	}

	@Override
	public String toString() {
		return "ImmutableStudent{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
