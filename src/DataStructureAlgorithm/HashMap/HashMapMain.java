package DataStructureAlgorithm.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HashMapMain {

	static String str = "";
	
	public static void main(String[] args) {
		Map<Employee, String> map = new HashMap<>();
		
		map.put(new Employee("a"), "aaa");
		map.put(new Employee("b"), "bbb");
		map.put(new Employee("a"), "aaa--");
		
		System.out.println(map.size());
		System.out.println(map.get(new Employee("a")));
		
		Map<String, String> tmp = new HashMap<>();
		tmp.put(new String("a"), "audi");
		tmp.put(new String("a"), "aaa");
		System.out.println(tmp);
		
		//----------------------------------------------
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(1);
		q.add(2);
		q.add(3);
		
		System.out.println(q.poll());
		System.out.println(q.offer(4));
		q.add(1);
		q.remove(2);
		System.out.println(q.peek());
		System.out.println(q);
		
		//----------------------------------------------
		try{
			str += "a";
			throw new Exception();
		} catch(Exception e){
			str += "b";
		} finally {
			str += "c";
			//method();
			str += "d";
			
		}
		System.out.println(str);
		//----------------------------------------------
		
		Map<String, String> tmpmap = new HashMap<>();
		
		tmpmap.put("1", "suvarna");
		tmpmap.put("2", "anup");
		tmpmap.put("3", "rakshi");
		
		for(String str : tmpmap.keySet()){
			System.out.println(str + " - " + tmpmap.get(str));
		}
		
		System.out.println("---------------------------");
		
		for(Map.Entry<String, String> entry : tmpmap.entrySet()){
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println("----------------------------");
		
		Iterator<Map.Entry<String, String>>entries = tmpmap.entrySet().iterator();
		while(entries.hasNext()){
			Map.Entry<String, String> entry = entries.next();
			if(entry.getKey().equals("1")){
				tmpmap.put("1", "Sandeepaaaa");
			}
			System.out.println(entry.getKey() + " - " + entry.getValue());
			
		}
		
		System.out.println("-------------------Hashmap value sorting-----------------------");
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
		  
        // enter data into hashmap 
        hm.put("Math", 98); 
        hm.put("Data Structure", 85); 
        hm.put("Database", 91); 
        hm.put("Java", 95); 
        hm.put("Operating System", 79); 
        hm.put("Networking", 80); 
        Map<String, Integer> hm1 = sortByValue(hm); 
  
        // print the sorted hashmap 
        for (Map.Entry<String, Integer> en : hm1.entrySet()) { 
            System.out.println("Key = " + en.getKey() +  
                          ", Value = " + en.getValue()); 
        } 
        
        System.out.println("-------------------Hashmap key sorting-----------------------");
        sortbykey(hm);
	}
	static void method(){
		throw new NullPointerException();
	}
	
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
	
	public static void sortbykey(Map<String, Integer> map) 
    { 
        ArrayList<String> sortedKeys = 
                    new ArrayList<String>(map.keySet()); 
          
        Collections.sort(sortedKeys);  
  
        // Display the TreeMap which is naturally sorted 
        for (String x : sortedKeys)  
            System.out.println("Key = " + x +  
                        ", Value = " + map.get(x));      
    } 
}
