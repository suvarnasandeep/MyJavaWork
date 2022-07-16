package Externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Customer implements Externalizable{
	int customerId;
	String name;
	int age;
	
	public Customer() {
		System.out.println("default constructor");
	}

	public Customer(int customerId, String name, int age) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.age = age;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		int age = in.readInt();
		String name = (String) in.readObject();
		
	}
	
	public String toString(){
		return "customer details : "+ name + "|" + age + "|" + customerId;
	}
	
	
}
