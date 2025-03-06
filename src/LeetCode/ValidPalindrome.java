package LeetCode;

public class ValidPalindrome {
    /**
    Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:
    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

    Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.
     */

    public static void main(String[] args) {
        //String s = "A man, a plan, a canal: Panama";
        //String s = "race a car";
        String s = " ";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String str){
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        int start = 0;
        int end = str.length()-1;
        while (start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
