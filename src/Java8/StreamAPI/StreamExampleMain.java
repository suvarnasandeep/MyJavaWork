package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExampleMain {

	public static void main(String[] args) {

		List<String> list =new ArrayList<>(Arrays.asList("sandeep", "anu", "rak", "niri"));

		
		//list.stream().forEach(System.out::println);
		
		/*System.out.println("stream process-->>");
		list.stream().filter(str -> str.length() != 3).
						map(String::toUpperCase).
						sorted().
						forEach(str -> System.out.print(" "+str));
		System.out.println();
		//parralel stream
		System.out.println("parallel stream process-->>");
		list.parallelStream().filter(str -> str.length() == 3).
								map(String::toUpperCase).
								sorted().
								forEach(str -> System.out.print(" "+str));

		System.out.println();
		//concurrant modification
		System.out.println("concurrent mod stream process-->>");
		Stream<String> vStream = list.parallelStream();		
		list.add("abc");

		vStream.filter(str -> str.length()==3).
					map(String::toUpperCase).
					sorted().
					forEach(System.out::println);
		System.out.println();*/

		/*//diff way of creating stream
		System.out.println("diff way to create stream-->>");
		Stream<Integer> newStream = Stream.of(1,2,3,4,5);
		newStream.forEach(t -> System.out.print(" "+t));
		System.out.println();

		Stream<Integer> newStream1 = Stream.of(new Integer[]{1,2,3,4});
		newStream1.forEach(t -> System.out.print(" "+t));
		System.out.println();

		//stream generate
		System.out.println("generate stream-->>");
		Stream<UUID> uuidStream = Stream.generate(UUID::randomUUID);
		uuidStream.limit(2).forEach(t -> System.out.println(" " +t));
*/
		//stream flatmap
		/*System.out.println("flatmap stream-->>");
		Stream<String> newStream3 = list.stream();
		//newStream3.flatMap(str -> Stream.of(str.charAt(0))).forEach(System.out::print);
		newStream3.flatMap(str -> Stream.of(str.length())).forEach(System.out::print);
		System.out.println();*/

		/*//peek
		System.out.println("peek stream-->>");
		Stream<String> newStream4 = list.stream();
		newStream4.filter(str -> str.length() >2).
					peek(p -> System.out.println("filtered val :" + p)).
					map(String::toUpperCase).
					peek(e -> System.out.println("mapped val :" +e)).
					forEach(System.out::println);
		System.out.println();*/


		//distinct
		/*System.out.println("distinct stream-->>");
		Stream.of("sandy", "anu", "raks", "anu","rak").distinct().forEach(str -> System.out.print(" "+str));
		System.out.println();


		//sort
		System.out.println("sort stream-->>");
		Stream.of("sandy", "anu", "raks","rak").sorted().forEach(str -> System.out.print(" "+str));
		System.out.println();
*/
		//custom object
		/*List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("kapil", "cse", 10000));
		empList.add(new Employee("vishnu", "eee", 25000));
		empList.add(new Employee("prashant", "ece", 30000));
		empList.add(new Employee("sandeep", "ip", 55000));
		empList.add(new Employee("anu", "ipp", 50000));
/*
		empList.stream().sorted((Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName())).
							forEach(System.out::println);

		System.out.println("-----------------------------------");

		empList.stream().sorted((Employee o1, Employee o2) -> o2.getSalary() - o1.getSalary()).forEach(System.out::println);*/

		/*empList.stream().filter((employee -> employee.getSalary() > 25000))
				.forEach(System.out::println);

		List<Employee> resList = empList.stream().filter((employee -> employee.getSalary() > 25000))
				.collect(Collectors.toList());
		System.out.println("-----------------------------------");*/

		//map demo
		/*List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("kapil", "cse", 10000));
		empList.add(new Employee("vishnu", "eee", 25000));
		empList.add(new Employee("prashant", "ece", 30000));
		empList.add(new Employee("sandeep", "ip", 55000));
		empList.add(new Employee("anu", "ipp", 50000));

		empList.stream().forEach(System.out::println);

		System.out.println("---------------------------");

		empList.stream().map((Employee emp) -> new EmployeeDTO(emp.getName(), emp.getDept()))
			.forEach(System.out::println);

		System.out.println("---------------------------");*/
		//reduce
		//wit accumulator
		System.out.println("reduce with accumulator stream-->>");
		Stream.of(10, 20,30,40,50).reduce((x,y)-> x+y).
									ifPresent(System.out::print);
		System.out.println();
		Stream.of("sandeep", "anup", "rakshi").reduce((str1,str2)->str1 +" | " + str2).
												ifPresent(System.out::print);
		System.out.println();

		//with accumulator and identity
		System.out.println("reduce with accumulator and identity stream-->>");
		int sum = Stream.of(10, 20,30,40,50).reduce(1000 , (x,y)-> x+y);
		System.out.println(sum);									
		
		String result = Stream.of("sandeep", "anup", "rakshi").reduce("Friends = " ,(str1,str2)->str1 +" | " + str2);
		System.out.println(result);
		
		//with accumulator, identity and combiner
		System.out.println("reduce with accumulator, identity and combiner stream-->>");
		Integer arrSum = Stream.of(10,20,22,12,14).parallel().reduce(1000, (x,y)->x+y, (p,q)->{
            System.out.println("combiner called");
            return p+q;
        });
        System.out.println(arrSum);
        
        //collect
        System.out.println("collect stream-->>");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Nataraja G", "Accounts", 8000));
        employeeList.add(new Employee("Nagesh Y", "Admin", 15000));
        employeeList.add(new Employee("Vasu V", "Security", 2500));
        employeeList.add(new Employee("Amar", "Entertainment", 12500));
 
        // find employees whose salaries are above 10000
        List<Employee> filteredList = employeeList.stream()
                                            .filter(emp->emp.getSalary() > 10000)
                                            .collect(Collectors.toList());
 
        filteredList.forEach(System.out::println);
        
        //stream concat
        System.out.println("concat stream-->>");
        List<Employee> concatListOne = new ArrayList<>();
        concatListOne.add(new Employee("sandeep", "Accounts", 8000));
        concatListOne.add(new Employee("anup", "Admin", 15000));
        List<Employee> concatListTwo = new ArrayList<>();
        concatListTwo.add(new Employee("Nitin", "Accounts", 8000));
        
        Stream.concat(concatListOne.stream(), concatListTwo.stream()).forEach(System.out::println);
        
        //anyMatch() allMatch() noneMatch() findFirst() findAny()
        boolean res = concatListOne.stream().anyMatch(emp -> emp.getDept().matches("Admin"));
        System.out.println(res);
        res = concatListOne.stream().allMatch(emp -> emp.getDept().matches("Admin"));
        System.out.println(res);
        res = concatListOne.stream().noneMatch(emp -> emp.getDept().matches("Admin"));
        System.out.println(res);
        
        concatListOne.stream().filter(emp->emp.getDept().matches("Admin")).
        						findFirst().
        						ifPresent(System.out::println);

        concatListOne.stream().filter(emp->emp.getDept().matches("Admin")).
        						findAny().
        						ifPresent(System.out::println);
	}

}
