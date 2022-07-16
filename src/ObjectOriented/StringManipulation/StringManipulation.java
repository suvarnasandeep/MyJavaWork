package StringManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class StringManipulation {

	public boolean checkCircular(String str1, String str2) {
		
		if(str1.length() != str2.length())
			return false;
		String str = str1 + str1;
		if(str.contains(str2)){
			return true;
		} else {
			return false;
		}
	}
	
	public void printDuplicate(String str) {
		
		Map<Character, Integer> map = new LinkedHashMap();
		
		char[] arr = str.toCharArray();
		
		for(char ch : arr){
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) +1);
			} else {
				map.put(ch, 1);
			}
		}
		
		Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Character, Integer>> entrySetIterator = entrySet.iterator();
		while(entrySetIterator.hasNext()){
			Entry<Character, Integer> entry = entrySetIterator.next();
			System.out.println(entry.getKey() +" -> " + entry.getValue());
		}
	}
	
	public void checkAnagram(String str1 , String str2) {
		
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		System.out.println(Arrays.equals(arr1,  arr2));
	}
	
	public void checkAnagram1(String str1 , String str2) {
		char[] arr = str1.toCharArray();
		StringBuilder sbuild = new StringBuilder(str2);
		
		for(char ch : arr){
			int index = sbuild.indexOf(""+ch);
			if(index != -1){
				sbuild.deleteCharAt(index);
			} else {
				System.out.println("false");
			}
		}
		
		System.out.println(sbuild.length()==0 ? "true" : "false");
	}
	
	public void checkStringForNumber(String str) {
		
		Pattern patter = Pattern.compile(".*[^0-9].*");
		System.out.println(str +" -> " + !patter.matcher(str).matches());
	}
	
	public void permutation(String str) {
		//perm("", str);
		
		int n = str.length();
		permute(str, 0, n-1);
	}
	
	public void permute(String str, int l, int r) {
		
		if(l == r){
			System.out.println(str);
		} else {
			for(int i = l; i <= r; i++){
				str = swap(str, l,i);
				permute(str, l+1, r);
				str = swap(str, l, i);
			}
		}
	}
	
	public String swap(String str, int i, int j) {
		char tmp;
		char [] charArr = str.toCharArray();
		tmp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = tmp;
		return String.valueOf(charArr);
	}
	
	public void perm(String perm, String word) {
		if(word.isEmpty()){
			System.out.println(perm + word);
		}else {
			for(int i=0; i< word.length(); i++){
				perm(perm + word.charAt(i), word.substring(0, i) + word.substring(i+1, word.length()));
			}
		}
	}
	
	//input -aabbccca  output -a2b2c3a1
	public void printOccur(String str) {
		List<String> list = new ArrayList<>();
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		char[] arr = str.toCharArray();	
		int count = 0;
		char prev = 0;
		for(char ch : arr){
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) + 1);
				prev = ch;
			} else {
				if(count != 0){
					
					int j = map.get(prev);
					String cc = String.valueOf(j);
					String var = prev + cc;
					list.add(var);
					map.remove(prev);
				}
				map.put(ch, 1);
				count++;
			}
		}
		if(!map.isEmpty()){
			for(Map.Entry<Character, Integer> entry : map.entrySet()){
				String str1 =  entry.getKey()  + String.valueOf(entry.getValue());
				list.add(str1);
			}
		}
		
		for(String ss : list){
			System.out.println(ss);
		}
	}
}
