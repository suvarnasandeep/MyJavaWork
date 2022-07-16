package Serialization;

import java.io.Serializable;

public class PrevCustomer1 extends Customer1 implements Serializable{
	int discountRate;
	int discount;
	
	
	public String toString(){
		return "PrevCustomer : |" + custId + "|" + name + "|" + discountRate + "|" + discount;
	}
}
