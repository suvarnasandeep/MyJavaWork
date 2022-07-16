package MethodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import LamdaExpression.Employee;

public class InstanceMethodReference {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee("sandeep", "eee", 30000));
		list.add(new Employee("anu", "cs", 50000));
		list.add(new Employee("prashant", "ece", 35000));
		
		EmployeeComparator compObj = new EmployeeComparator();
		
		//object::instanceMethodName	-> x::toString -> () -> "java2novice".toString()
		
		System.out.println("method ref way -->");
		Collections.sort(list, compObj::compare);
		list.forEach(System.out::println);
		
		System.out.println("Lambda expression --->");
        Collections.sort(list, (emp1, emp2) -> compObj.compare(emp1, emp2));
        list.forEach(System.out::println);

	}

}
