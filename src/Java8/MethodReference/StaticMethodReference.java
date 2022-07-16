package MethodReference;

import java.util.ArrayList;
import java.util.List;

public class StaticMethodReference {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("sandeep");
		list.add("anu");
		list.add("rakshi");
		
		//Class::staticMethodName	-> String::valueOf -> (s) -> String.valueOf(s)
		
		System.out.println("---------java 7 way -------");
		for(String str : list){
			StaticMethodReference.printStr(str);
		}
		
		System.out.println("----------method ref way -----");
		list.forEach(StaticMethodReference::printStr);
		
		System.out.println("-------lamda way ------");
		list.forEach(str-> StaticMethodReference.printStr(str));
	}
	
	public static void printStr(String str) {
		System.out.println(str);
	}
}
