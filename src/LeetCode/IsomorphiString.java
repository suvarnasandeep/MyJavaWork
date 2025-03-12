package LeetCode;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class IsomorphiString {
    /**
     Example 1:
     Input: s = "egg", t = "add"
     Output: true
     Explanation:
     The strings s and t can be made identical by:
     Mapping 'e' to 'a'.
     Mapping 'g' to 'd'.

     Example 2:
     Input: s = "foo", t = "bar"
     Output: false
     Explanation:
     The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
     */
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s,t));
    }

    private static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        if(s.length() != t.length())
            return false;

        for (int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), i);
            if(!map1.containsKey(t.charAt(i)))
                map1.put(t.charAt(i), i);

            if(!map.get(s.charAt(i)).equals(map1.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}
