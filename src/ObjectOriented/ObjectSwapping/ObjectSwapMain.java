package ObjectSwapping;

public class ObjectSwapMain {

	public static void main(String[] args) {
		Student obj1 = new Student("sandeep", 121);
		Student obj2 = new Student("anup", 456);
		
		
		
		StudentWrapper wrapObj1 = new StudentWrapper(obj1);
		StudentWrapper wrapObj2 = new StudentWrapper(obj2);
		
		obj1.print();
		obj2.print();
		
		swap(wrapObj1, wrapObj2);

		wrapObj1.obj.print();
		wrapObj2.obj.print();
	}
	
	public static void swap(StudentWrapper cw1, StudentWrapper cw2) {
		
		Student temp = cw1.obj;
		cw1.obj = cw2.obj;
		cw2.obj = temp;
	}

}
