package Stack;

import java.util.Stack;

public class ReverseNumber {
    Stack s = new Stack();

    public void pushDigit(int num){

        while(num != 0){
            s.push(num%10);
            num = num/10;
        }
    }

    public int reverseNumber(int num){
        int reverse = 0;
        int i=1;
        pushDigit(num);
        //System.out.println(s);

        while(!s.isEmpty()){
            reverse = reverse  +
                    (int)s.pop() * i;
            i*=10;
        }


        return reverse;
    }
}