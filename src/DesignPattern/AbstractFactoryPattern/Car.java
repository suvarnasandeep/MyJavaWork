package AbstractFactoryPattern;

public abstract class Car {
	private String model;
	private String location;
	
	public Car(String model, String location) {
		this.model = model;
		this.location = location;
	}
	
	public abstract void construct();
	
	public String toString() {
		return "model : " + this.model + " location : "+this.location;
	}
}
