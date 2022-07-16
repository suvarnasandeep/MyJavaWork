package FactoryPattern;

public class SedanCar extends Car{
	
	public SedanCar() {
		construct();
	}

	@Override
	public void construct() {
		System.out.println("constructing sedan car");
	}

}
