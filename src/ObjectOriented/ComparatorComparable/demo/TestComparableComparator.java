package ComparatorComparable.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestComparableComparator {
	
	public static void main(String[] args) {
		
		List<Person> personList = new ArrayList<Person>();
	    personList.add(new Person("William", "Shatner", 60));
	    personList.add(new Person("William", "Brooks", 25));
	    personList.add(new Person("Persis", "Khambatta", 50));
	    personList.add(new Person("James", "Doohan", 70));
	    personList.add(new Person("DeForest", "Kelley", 65));
	    
	    System.out.println("-- Original List --");
	    for(Person p : personList) {
	    	System.out.println(p);
	    }
	    
	    Collections.sort(personList);
	    System.out.println("-- Sorted List --");
	    for(Person p : personList) {
	    	System.out.println(p);
	    }
	    
	    System.out.println("-------------------------");
	    // Sort the list by age
	    Collections.sort(personList, new AgeComparator());
	    System.out.println("--Sorted List by Age--");
	    for(Person person : personList){
	     System.out.println("" + person);
	    } 
	    System.out.println("-------------------------");
	 // Sort the list by last name
	    Collections.sort(personList, new NameComparator());
	    System.out.println("--Sorted List by Last Name--");
	    for(Person person : personList){
	     System.out.println("" + person);
	    } 
	}

}
