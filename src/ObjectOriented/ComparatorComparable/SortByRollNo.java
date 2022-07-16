package ComparatorComparable;

import java.util.Comparator;

public class SortByRollNo implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		 return o1.rollNo - o2.rollNo;
	}
}
