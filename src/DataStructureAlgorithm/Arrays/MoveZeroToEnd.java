package DataStructureAlgorithm.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroToEnd {

/*
    input [0,4,0,3,1,6,0,5,0]
    output [4,3,1,6,5,0,0,0,0]
 */
    public static void main(String[] args) {
        int[] arr = {0,4,0,3,1,6,0,5,0};
        Utils.printArray(arr);
        //moveZeroBF(arr);
        moveZero(arr);
        Utils.printArray(arr);
    }

    private static void moveZero(int[] arr) {
        int i = -1;
        for (int j=0; j<arr.length; j++){
            if(arr[j] == 0 && i==-1){
                i=j;
            } else if(arr[j] != 0 && i !=-1){
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }
    }

    //int[] arr = {0,4,0,3,1,6,0,5,0}
    public static void moveZero1(int[] arr){
        int j=-1;
        for (int i=0; i<arr.length; i++){
            if (arr[i] == 0){
                j=i;
                break;
            }
        }
        for (int k=j+1; k<arr.length; k++){
            if(arr[k] != 0){
                int tmp = arr[k];
                arr[k] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }
    }

    private static void moveZeroBF(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++){
            if(arr[i] !=0)
                list.add(arr[i]);
        }
        for (int j=0; j<list.size(); j++){
            arr[j] = list.get(j);
        }
        for (int k = list.size(); k< arr.length; k++){
            arr[k] = 0;
        }
    }
}
