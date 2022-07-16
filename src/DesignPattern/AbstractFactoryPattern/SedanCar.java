package AbstractFactoryPattern;

public class SedanCar extends Car {

	public SedanCar(String model, String location) {
		super(model, location);
		construct();
	}

	@Override
	public void construct() {
		System.out.println("constructing sedan car");
		
	}

}
