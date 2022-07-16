package FailFastFailSafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafeDemo {


    public static void main(String[] args){

        //CopyOnWriteArrayList<String> myListCC = new CopyOnWriteArrayList<String>();
        List<String> myList = new ArrayList<String>();

        List<String> nameList = Arrays.asList("sandeep", "Niri", "Anu", "Raks");

        myList.addAll(nameList);

        for(String name : myList){
            System.out.println(name);
            //myList.remove(2);
        }

        System.out.println("-------------------------");

        Iterator<String> itr = myList.iterator();
        while(itr.hasNext()){
            String name = itr.next();

            if(name.equals("Niri")){
                //myList.remove(1);
                itr.remove();
                //myListCC.add("suvarna");
            }
        }

        for(String name : myList){
            System.out.println(name);
        }

    }
}
