package ComparatorComparable;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();		
		list.add(new Student("sandeep", "HAL", 121));
		list.add(new Student("anu", "indiranagar", 596));
		list.add(new Student("rakshi", "mumbai", 10));		
		print(list);		
		Collections.sort(list, new SortByName());		
		print(list);
		Collections.sort(list, new SortByRollNo());
		print(list);
		System.out.println("------------------------------");

		List<Movie> list1 = new ArrayList<>();
		list1.add(new Movie("sandeep", 2005, 121));
		list1.add(new Movie("anu", 1990, 596));
		list1.add(new Movie("rakshi", 2015, 10));
		printList(list1);
		Collections.sort(list1);		
		printList(list1);
	}

	public static void printList(List<Movie> list) {

		for(Movie st: list){
			System.out.println(st.getName() + " " + st.getYear()+ " " + st.getRating());
		}
		System.out.println("------------------------");
	}

	public static void print(List<Student> list) {

		for(Student st: list){
			System.out.println(st.getName() + " " + st.getAdd()+ " " + st.getRollNo());
		}
		System.out.println("------------------------");
	}

}
