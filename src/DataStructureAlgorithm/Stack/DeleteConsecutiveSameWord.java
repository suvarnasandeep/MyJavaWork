package Stack;

/*
        Input : ab aa aa bcd ab
        Output : 3
        As aa, aa destroys each other so, ab bcd ab is the
        new sequence.

        Input :  tom jerry jerry tom
        Output : 0
        As first both jerry will destroy each other.
        Then sequence will be tom, tom they will also destroy
        each other. So, the final sequence doesn't contain any
        word.
*/

import java.util.Stack;

public class DeleteConsecutiveSameWord {

    public int deleteConsecutiveWord(String[] arr){

        Stack s = new Stack();
        for(String str : arr){
            if(s.isEmpty()){
                s.push(str);
            } else {
                while(!s.isEmpty()){
                    if(str.equalsIgnoreCase((String) s.peek())){
                        s.pop();
                        break;

                    } else {
                        s.push(str);
                        break;
                    }
                }
            }

        }


        return s.size();
    }
}
