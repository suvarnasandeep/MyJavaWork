package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    private static boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for (int j=0; j<t.length(); j++){
            Character tc = t.charAt(j);
            if(!map.containsKey(tc) || map.get(tc) == 0){
                return false;
            }
            map.put(tc, map.get(tc)-1);
        }
        return true;
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i),0) +1);
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i),0) +1);
        }

        return smap.equals(tmap);
    }
}
