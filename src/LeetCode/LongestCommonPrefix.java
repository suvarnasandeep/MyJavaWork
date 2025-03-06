package LeetCode;

public class LongestCommonPrefix {
    /*
    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
     */
    public static void main(String[] args) {
        //String[] strs = {"flower", "flight", "flow"};
        //String[] strs = {"dog", "racecar", "flight"};
        String[] strs = {"reflower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length == 0)
            return "";

        if(strs.length == 1)
            return strs[0];

        String res = strs[0];
        int len = res.length();

        for (int i=1; i< strs.length; i++){
            String str = strs[i];

            if(str.equals(res)){
                continue;
            }

            while (len > str.length() || !res.equals(str.substring(0, len))){
                len--;
                if(len==0)
                    return "";
                res = res.substring(0, len);
            }
        }
        return res;

    }
}
