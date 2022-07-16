package DefaultAndStaticMethod;

public interface Interface {
	
	public void method1();
	
	default public void log(){
		System.out.println("Interface default method");
	}
}
