package Searching;

public class LinearSearch {
    public void linearSearch(int[] input, int toSearch) {
        boolean found  = false;

        for(int i: input){
            if(i == toSearch){
                found = true;
            }

            if(i > toSearch){
                break;
            }
        }

        System.out.println("Number " + toSearch + " found : " + found);
    }
}
