package DefaultAndStaticMethod;

public interface Interface1 {

	public void method2();

	default public void log(){
		System.out.println("Interface1 default method");
	}
}
