package FactoryPattern;

public class FactoryMain {

	public static void main(String[] args) {
		Car sedanCar = CarFactory.getCar("sedan");
		Car suvCar = CarFactory.getCar("Suv");
		

	}

}
