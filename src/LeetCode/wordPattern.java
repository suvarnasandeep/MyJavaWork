package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class wordPattern {
    /**
     * Example 1:     *
     * Input: pattern = "abba", s = "dog cat cat dog"     *
     * Output: true
     * Explanation:     *
     * The bijection can be established as:
     * 'a' maps to "dog".
     * 'b' maps to "cat".
     *
     * Example 2:
     * Input: pattern = "abba", s = "dog cat cat fish"     *
     * Output: false
     *
     * Example 3:
     * Input: pattern = "aaaa", s = "dog cat cat dog"
     * Output: false
     */

    public static void main(String[] args) {
        /*String pattern = "abba";
        String s = "dog cat cat dog";*/
        /*String pattern = "abba";
        String s = "dog cat cat fish";*/
        /*String pattern = "aaaa";
        String s = "dog cat cat dog";*/
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(pattern, s));
    }

    private static boolean wordPattern(String pattern, String s){
        Map<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] arr = s.split(" ");

        if(pattern.length() != arr.length)
            return false;

        for (int i=0; i<pattern.length(); i++){
            Character c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i])){
                    return false;
                }
            } else {
                if (set.contains(arr[i])){
                    return false;
                }
                map.put(c, arr[i]);
                set.add(arr[i]);

            }
        }
        return true;
    }

}
