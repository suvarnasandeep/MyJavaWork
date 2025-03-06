package LeetCode;

public class ReverseWordsInString {
    /**
    Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"

    Example 2:
    Input: s = "  hello world  "
    Output: "world hello"
     */
    public static void main(String[] args) {
        String s = " the sky  is blue";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i= arr.length-1; i>=0; i--){
            sb.append(arr[i]);
            if(i!=0)
                sb.append(" ");
        }

        return sb.toString();
    }
}
