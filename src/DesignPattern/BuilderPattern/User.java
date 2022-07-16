package BuilderPattern;

public class User {
	private final String firstName;
	private final String lastName;
	private final String age;
	private final String salary;
	private final String residence;
	
	public User(UserBuilder user) {
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.age = user.age;
		this.salary = user.salary;
		this.residence = user.residence;
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.age + " " + this.salary + " " + this.residence;
	}
	
	public static class UserBuilder{
		private final String firstName;
		private final String lastName;
		private String age;
		private String salary;
		private String residence;
		
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public UserBuilder age(String age){
			this.age = age;
			return this;
		}
		
		public UserBuilder salary(String salary){
			this.salary = salary;
			return this;
		}
		
		public UserBuilder residence(String residence){
			this.residence = residence;
			return this;
		}
		
		public User build(){
			User user = new User(this);
			return user;
		}
	}
}
