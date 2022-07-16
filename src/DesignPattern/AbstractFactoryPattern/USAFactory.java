package AbstractFactoryPattern;

public class USAFactory {
	public static Car buildCar(String type) {
		Car car = null;
		switch (type) {
		case "Sedan":
			car = new SedanCar(type, "USA");
			break;
		case "Suv":
			car = new SuvCar(type, "USA");
			break;

		default:
			break;
		}

		return car;
	}
}
