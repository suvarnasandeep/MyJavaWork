package HashMap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HashMapSorting {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("1", "sandeep");
		map.put("2", "sandeep2");
		map.put("22", "sandeep22");
		map.put("45", "sandeep45");

		System.out.println("--------sort map by key-------------");

		for(Map.Entry<String, String> emap : map.entrySet()) {
			System.out.println(emap.getKey() + " / " + emap.getValue() );
		}

		System.out.println("---------------------");

		TreeMap<String, String> treeMap = new TreeMap<>(map);

		for(Map.Entry<String, String> map1 : treeMap.entrySet()) {
			System.out.println(map1.getKey() + " / " + map1.getValue() );
		}

		System.out.println("--------sort map by value-------------");
		/*Map<String, String> mapv = new HashMap<String, String>();

		mapv.put("1", "sandeep");
		mapv.put("2", "Niri");
		mapv.put("22", "Anup");
		mapv.put("45", "Rakshi");


		for(Map.Entry<String, String> emap : mapv.entrySet()) {
			System.out.println(emap.getKey() + " / " + emap.getValue() );
		}

		System.out.println("---------------------");

		Set<String> set = new TreeSet<>(mapv.values());
		for(String val : set) {
			System.out.println(val);
		}*/

		System.out.println("---------------------");

		HashMap<String, String> mapv1 = new HashMap<String, String>();

		mapv1.put("1", "sandeep");
		mapv1.put("2", "Niri");
		mapv1.put("22", "Anup");
		mapv1.put("45", "Rakshi");
		Map<String, String> res = sortByValue(mapv1);

		for(Map.Entry<String, String> mv : res.entrySet()) {
			System.out.println(mv.getKey() + " " + mv.getValue());
		}

	}

	public static HashMap<String, String> sortByValue(HashMap<String, String> hm) {		

		List<Map.Entry<String, String> > list =
				new LinkedList<Map.Entry<String, String> >(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, String> >() {
			public int compare(Map.Entry<String, String> o1,
					Map.Entry<String, String> o2)
			{
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, String> temp = new LinkedHashMap<String, String>();
		for (Map.Entry<String, String> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;

		//using stream api
		/*HashMap<String, String> temp
        = hm.entrySet()
              .stream()
              .sorted((i1, i2)
                          -> i1.getValue().compareTo(
                              i2.getValue()))
              .collect(Collectors.toMap(
                  Map.Entry::getKey,
                  Map.Entry::getValue,
                  (e1, e2) -> e1, LinkedHashMap::new));

    return temp;*/
	}

}
