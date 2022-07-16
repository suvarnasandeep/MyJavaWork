package AbstractFactoryPattern;

public class GermanCarFactory {

	public static Car buildCar(String type) {
		Car car = null;
		switch (type) {
		case "Sedan":
			car = new SedanCar(type, "Germany");
			break;
		case "Suv":
			car = new SuvCar(type, "Germany");
			break;

		default:
			break;
		}

		return car;
	}

}
