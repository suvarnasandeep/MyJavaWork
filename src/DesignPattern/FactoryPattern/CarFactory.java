package FactoryPattern;

public class CarFactory {
	public static Car getCar(String carType) {
		Car car = null;
		switch (carType) {
		case "sedan":
			car = new SedanCar();
			break;
		case "Suv":
			car = new SUVCar();
			break;

		default:
			break;
		}
		return car;
	}
}
