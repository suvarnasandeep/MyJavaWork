package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    /**
     Example 1:
     Input: ransomNote = "a", magazine = "b"
     Output: false

     Example 2:
     Input: ransomNote = "aa", magazine = "ab"
     Output: false

     Example 3:
     Input: ransomNote = "aa", magazine = "aab"
     Output: true
     */

    public static void main(String[] args) {
       /* String ransom = "a";
        String magazine = "b";*/

        String ransom = "aa";
        String magazine = "ab";

        System.out.println(ransomNote(ransom, magazine));
    }

    public  static boolean ransomNote(String ransomNote, String magazine){
        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for (char c : ransomNote.toCharArray()){
            if(map.containsKey(c) && map.get(c)>0){
                map.put(c, map.get(c)-1);
            } else {
                return false;
            }
        }
        return true;
    }
}
