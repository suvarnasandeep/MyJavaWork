package Serialization;

import java.io.Serializable;

public class Customer implements Serializable{

	int custId;
	String name;
	
	public String toString(){
		return "Customer: |" + custId + "|" + name;
		
	}
}
