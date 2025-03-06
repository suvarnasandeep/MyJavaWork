package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class IndexOfFirstOccurence {

    public static void main(String[] args) {
        String haystack = "asadbutsad";
        String needle = "sad";

        System.out.println(strstr(haystack, needle));
    }

    private static int strstr(String haystack, String needle) {
        int j=needle.length();
        for(int i=0; j <= haystack.length(); i++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
            j++;
        }
        return -1;

    }
}
