package Externalization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizationMain {

	public static void main(String[] args) {
		Customer obj = new Customer(12345, "sandeep", 28);
		
		FileOutputStream foo = null;
		ObjectOutputStream ooo = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		Customer desObj = null;
		
		try {
			foo = new FileOutputStream("file.ser");
			ooo = new ObjectOutputStream(foo);
			ooo.writeObject(obj);
			ooo.flush();
			ooo.close();
			
			fis = new FileInputStream("file.ser");
			ois = new ObjectInputStream(fis);
			desObj = (Customer) ois.readObject();
			ois.close();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(desObj);
	}

}
