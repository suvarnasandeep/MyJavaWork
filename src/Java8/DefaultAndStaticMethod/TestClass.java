package DefaultAndStaticMethod;

public class TestClass implements Interface, Interface1{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log() {
		// TODO Auto-generated method stub
		Interface.super.log();
	}

}
