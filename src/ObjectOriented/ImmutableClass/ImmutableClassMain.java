package ImmutableClass;

public class ImmutableClassMain {

	public static void main(String[] args) {
		
		StudentAge age = new StudentAge(1, 1, 1990);
		ImmutableStudent obj = new ImmutableStudent("sandeep", age);
		
		System.out.println(obj);
		age.setYear(2000);
		System.out.println(obj);
		
		obj.getAge().setYear(2000);
		System.out.println(obj);

	}

}
