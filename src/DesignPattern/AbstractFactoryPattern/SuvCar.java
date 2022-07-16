package AbstractFactoryPattern;

public class SuvCar extends Car{

	public SuvCar(String model, String location) {
		super(model, location);
		construct();
	}

	@Override
	public void construct() {
		System.out.println("constructing Suv car");
		
	}

}
