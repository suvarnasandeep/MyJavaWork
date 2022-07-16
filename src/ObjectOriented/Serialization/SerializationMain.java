package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationMain {

	public static void main(String[] args) {

		//super class serialization
		PrevCustomer customer = new PrevCustomer();

		customer.name = "sandeep";
		customer.custId = 1234;
		customer.discountRate = 15;
		customer.discount = 1500;

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		Customer desCustomer = null;

		try {
			System.out.println("serialization starts");
			fos = new FileOutputStream("file.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(customer);
			oos.flush();
			oos.close();
			System.out.println("serialization ends");

			System.out.println("deserialization starts");
			fis = new FileInputStream("file.ser");
			ois = new ObjectInputStream(fis);
			desCustomer = (PrevCustomer) ois.readObject();
			ois.close();
			System.out.println("deserialization ends");

		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		}

		System.out.println(desCustomer);

		//sub class serialization
		/*PrevCustomer1 customer = new PrevCustomer1();

		customer.name = "sandeep";
		customer.custId = 1234;
		customer.discountRate = 15;
		customer.discount = 1500;

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		Customer1 desCustomer = null;

		try {
			System.out.println("serialization starts");
			fos = new FileOutputStream("file.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(customer);
			oos.flush();
			oos.close();
			System.out.println("serialization ends");

			System.out.println("deserialization starts");
			fis = new FileInputStream("file.ser");
			ois = new ObjectInputStream(fis);
			desCustomer = (PrevCustomer1) ois.readObject();
			ois.close();
			System.out.println("deserialization ends");

		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		}

		System.out.println(desCustomer);*/

	}

}
