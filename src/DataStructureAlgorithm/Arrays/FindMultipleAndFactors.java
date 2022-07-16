package Arrays;

import java.util.*;

/*
Give 2 arrays of integers, find
-multiple of first array
-factors of second array

Ex: a=[2,6]
    b=[24,36]

    multiples:
    2 = 2,4,6,8,10,12,....
    6 = 6,12,18,24,.....

    Factors:
    24 = 2,3,4,6,8,12
    36 = 2,3,4,6,9,12,18

    Ans = 6,12
 */
public class FindMultipleAndFactors {

    public List getMultipleAndFactorsBF(int[] a, int[] b){
        List<Integer> list = new ArrayList<Integer>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = a.length + b.length;

        int limit = 0;
        for(int i=0; i<b.length; i++){
           int max =  findFactors(b[i], map);
           if(limit < max){
               limit = max;
           }
        }

        for(int j=0; j<a.length; j++){
            findMultiples(a[j], map, limit);
        }

        for(int k : map.keySet()){
            if(map.get(k) == size){
                list.add(k);
            }
        }
        return list;
    }

    private void findMultiples(int b, Map<Integer, Integer> map, int limit) {
            for(int j=b; j<=limit; j++){
                if(j%b == 0){
                    int count = map.getOrDefault(j, 0);
                    count++;
                    map.put(j, count);
                }
            }
    }

    private int findFactors(int input, Map<Integer, Integer> map) {
        int res = 0;
        for(int i=2; i<=input; i++){
            if(input%i == 0){
                int count = map.getOrDefault(i, 0);
                count++;
                map.put(i, count);
                res = i;
            }
        }
        return  res;
    }

    /*
    -find LCM of first array
    -find GCD of second array
    -find multiples of LCM divisible by GCD
     */
    public List getMultipleAndFactors(int[] a, int[] b){

        List<Integer> list = new ArrayList<>();

        int lcm = a[0];
        for(int i : a){
            lcm = getLCM(lcm, i);
        }

        int gcd = b[0];
        for(int j:b){
            gcd = getGCD(gcd,j);
        }

        for(int k=lcm; k<=gcd; k++){
            if(gcd%k == 0)
                list.add(k);
            k++;
        }

        return list;
    }

    private int getLCM(int a, int b) {
        if(a==0 || b==0){
            return 0;
        }
        int gcd = getGCD(a,b);
        return Math.abs(a*b)/gcd;
    }

    private int getGCD(int a, int b) {
        if(b==0){
            return  a;
        }
        return getGCD(b, a%b);
    }


}
