package Serialization;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrevCustomer extends Customer{
	int discountRate;
	int discount;

	public String toString(){
		return "PrevCustomer : |" + custId + "|" + name + "|" + discountRate + "|" + discount;
	}

	//skip serialization
	/*private void writeObject(ObjectOutputStream out)
	         throws IOException {
	     throw new NotSerializableException("Can not serialize this class");
	    }

	private void readObject(ObjectInputStream in)
	         throws IOException, ClassNotFoundException {
	     throw new NotSerializableException("Can not serialize this class");
	    }*/
}
