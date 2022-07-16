package FactoryPattern;

public class SUVCar extends Car{
	
	public SUVCar() {
		construct();
	}

	@Override
	public void construct() {
		System.out.println("constructing SUV car");
		
	}

}
