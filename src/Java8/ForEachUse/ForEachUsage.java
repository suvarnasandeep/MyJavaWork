package ForEachUse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.omg.Messaging.SyncScopeHelper;

import LamdaExpression.Employee;

public class ForEachUsage {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		
		/*Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+" -> ");
		}
		System.out.println();*/
		
		list.forEach(t -> System.out.print(" " +t));
		
		System.out.println("-------------------------");
		list.forEach(new Consumer<Integer>(){			
			@Override
			public void accept(Integer t) {
				System.out.println("foreach annonymous class " +t+" -> ");
				
			}
		});
	
		System.out.println("-------------------------");
		MyConsumer consumer = new MyConsumer();
		list.forEach(consumer);
		System.out.println("-------------------------");
		
		//foreach map
		Map<String, String> map = new HashMap<>();
		map.put("sandeep", "suvarna");
		map.put("anup", "kumar");
		map.put("rakshi", "shetty");
		
		map.forEach((k,v)-> System.out.println(k +" " + v));
		
		System.out.println("-------------------------");
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("sandeep", "eee", 30000));
		empList.add(new Employee("anu", "cs", 50000));
		empList.add(new Employee("prashant", "ece", 35000));
		
		empList.forEach(p -> System.out.println(p));
		System.out.println("-------");
		empList.forEach(System.out::println);
	
	}
}
