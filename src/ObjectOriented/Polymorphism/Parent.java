package Polymorphism;

public class Parent {
	
	public int a = 10;
	
	public void m1(int a){
		System.out.println("parent m1");
	}
	public void m1() {
		System.out.println("parent m1");
	}
	public void m1(int... a){
		System.out.println("parent m1...");
	}
	
	public void m2() {
		System.out.println("parent m2");
	}
	
	public void m3() {
		System.out.println("parent m3");
	}
}
