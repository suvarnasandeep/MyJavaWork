package LamdaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaComparatorTest {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		LamdaComparatorTest obj = new LamdaComparatorTest();

		list.add(new Employee("sandeep", "eee", 30000));
		list.add(new Employee("anu", "cs", 50000));
		list.add(new Employee("prashant", "ece", 35000));
		
		for(Employee tmpEmp : list){
			System.out.println(tmpEmp.toString());
		}
		System.out.println("-----------------------");
		//obj.compareOldWay(list);
		
		obj.compareLamdaWay(list);

	}

	public void compareOldWay(List<Employee> list) {

		Collections.sort(list, new Comparator<Employee>() {
			public int	compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		
		list.forEach(emp->System.out.println(emp.toString()));
	}

	public void compareLamdaWay(List<Employee> list) {

		//Collections.sort(list, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));
		
		Comparator<Employee> asc = (Employee e1 , Employee e2) -> e1.getName().compareTo(e2.getName());
		Collections.sort(list, asc);
		
		list.forEach(emp->System.out.println(emp.toString()));
	}

}
