package MethodReference;

import java.util.Comparator;

public class EmployeeComparator{

	public int compare(LamdaExpression.Employee emp1, LamdaExpression.Employee emp2) {
		
		return emp1.getName().compareTo(emp2.getName());
	}
}
