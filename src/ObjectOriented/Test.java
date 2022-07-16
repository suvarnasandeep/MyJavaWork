import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public  static void main(String [] arg){

        List<Employee> list = new ArrayList<>();

        list.add(new Employee("dsandeep", "asuvarna", 32));
        list.add(new Employee("aNiri", "dpoojary", 27));
        list.add(new Employee("cAnup", "bnairy", 33));
        list.add(new Employee("bRakshi", "cshetty", 31));

        Test obj = new Test();
        obj.orderOldWay(list);
        System.out.println("---------------------------");
        obj.sortLambdaWay(list);
    }

    public void orderOldWay(List<Employee> list){

        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getLname().compareTo(o2.getLname());
            }
        });

        list.forEach(emp -> System.out.println(emp.toString()));
    }

    public void sortLambdaWay(List<Employee> list){

        Collections.sort(list, (o1, o2) -> o1.getFname().compareTo(o2.getFname()));

        list.forEach(emp -> System.out.println(emp.toString()));
    }
}


