package LeetCode;

public class SubSequence {
    /**
    Example 1:
    Input: s = "abc", t = "ahbgdc"
    Output: true

    Example 2:
    Input: s = "axc", t = "ahbgdc"
    Output: false
     */
    public static void main(String[] args) {
        /*String s = "abc";
        String t = "ahbgdc";*/

        /*String s = "axc";
        String t = "ahbgdc";*/

        /*String s = "aec";
        String t = "abcde";*/

        String s = "";
        String t = "abcde";

        /*String s = "b";
        String t = "abcde";*/

        System.out.println(isSubSequence(s,t));
    }

    public static boolean isSubSequence(String s, String t){

        int sp = 0;
        int tp = 0;

        while (sp <s.length() && tp < t.length()){
            if(s.charAt(sp) == t.charAt(tp)){
                sp++;
            }
            tp++;
        }
        return sp == s.length();

        /*int i=0;

        if(s.length() == 0)
            return true;

        for (int j =0; j<t.length(); j++){
            if(i > s.length()-1){
                break;
            }
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
        }
        return i==s.length();*/
    }
}
