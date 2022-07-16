package Stack;

public class NumberOfNextGreaterElements {

    //O(1)
    public int getNumberOfGreaterElements(int[] arr, int index){
        return 0;
    }

    //O(n)
    public int getNumberOfGreaterElementsBruteForce(int[] arr, int index){
        int num = 0;
        int size = arr.length;
        int ele = arr[index];

        for(int i = index+1; i<=size-1; i++){
            if(ele <= arr[i]){
                ele = arr[i];
                num++;
            }
        }

        return num;
    }
}
