package Polymorphism;

public class TestMain {

	public static void main(String[] args) {
		/*Parent obj = new Parent();
		
		obj.m1(3);
		obj.m2();*/
		
		Parent obj1 = new Child();
		obj1.m1(1,2);
		obj1.m2();
		obj1.m3();
		obj1.m1();
		
		
		System.out.println(obj1.a);
		
		Child o = new Child();
		o.m1(1,2);
		o.m2();
		o.m3();
		o.m1();
		System.out.println(o.a);
		/*o.m2();
		o.m();
		o.m1();
		o.m3();
		o.m1(1);*/
		
		/*Child obj = (Child) new Parent();
		obj.m1();*/
		
		

	}

}
