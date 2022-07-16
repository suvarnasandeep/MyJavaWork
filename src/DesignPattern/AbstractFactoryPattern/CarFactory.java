package AbstractFactoryPattern;

public class CarFactory {
	public static Car buildCar(String type, String location) {
		Car car = null;

		switch (location) {
		case "USA":
			car = USAFactory.buildCar(type);
			break;
		case "Germany":
			car = GermanCarFactory.buildCar(type);
			break;

		default:
			break;
		}
		return car;
	}
}
