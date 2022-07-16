package AbstractFactoryPattern;

public class FactoryMain {

	public static void main(String[] args) {
		Car suvCar = CarFactory.buildCar("Suv", "Germany");
		Car sedanCar = CarFactory.buildCar("Sedan", "USA");
		
		System.out.println(suvCar);
		System.out.println(sedanCar);

	}

}
