package DataStructureAlgorithm.Stack;

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

    public static void main(String[] args) {
        NumberOfNextGreaterElements obj = new NumberOfNextGreaterElements();

        int[] input = {3,4,2,7,5,8,10,6};
        int index = 2;

        System.out.print("[ ");
        for(int a : input){
            System.out.print(a + " ");
        }
        System.out.println(" ]");
        System.out.println("index : "+ index + " Num NGE : " + obj.getNumberOfGreaterElementsBruteForce(input, index));

    }
}
