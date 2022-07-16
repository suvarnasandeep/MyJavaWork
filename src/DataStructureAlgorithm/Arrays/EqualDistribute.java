package DataStructureAlgorithm.Arrays;

import java.util.Arrays;

/*
https://studyalgorithms.com/array/hackerrank-equal-solution/
Christy wants to give chocolates to her colleagues, and at the same time tries to ensure that everyone
 has equal chocolates at the end. To achieve this she either gives 1,2, or 5 chocolates
 to everyone except any one individual.
 find min number of operation needed so that every person has same num of chocolates
 */
public class EqualDistribute {

    public int getEqualDistribution(int [] arr){
        int[] possibility = new int[4];

        int min = Arrays.stream(arr).min().getAsInt();

        for(int i=0; i<possibility.length; i++){
            for(int k:arr){
                int diff = k-min;
                int stepsRequired = diff / 5 + (diff % 5) / 2 + ((diff % 5) % 2) / 1;
                possibility[i] += stepsRequired;
            }
            min--;
        }


        return Arrays.stream(possibility).min().getAsInt();
    }
}
