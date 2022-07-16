package ComparatorComparable.demo;

import java.util.Comparator;

public class NameComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		int comp = o1.getLastName().compareTo(o2.getLastName());
	    if(comp == 0){
	      comp = o1.getFirstName().compareTo(o2.getFirstName());
	    }
	    return comp;
	}

}
