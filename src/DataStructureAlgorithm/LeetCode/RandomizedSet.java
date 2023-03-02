package DataStructureAlgorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/*
    Insert Delete GetRandom O(1)
    Design a data structure that supports all following operations in average O(1) time.(Duplicate not allowed)

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom(): Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
public class RandomizedSet {
    public static Random rm = new Random();
    private HashMap<Integer,Integer> location;
    private ArrayList<Integer> data;

    public static void main(String[] args) {
        RandomizedSet randomizedCollection = new RandomizedSet();
        // return true since the collection does not contain 1.
        randomizedCollection.insert(1);
        // Inserts 1 into the collection.
        randomizedCollection.insert(1);   // return false since the collection contains 1.
        // Inserts another 1 into the collection. Collection now contains [1,1].
        randomizedCollection.insert(2);   // return true since the collection does not contain 2.
        // Inserts 2 into the collection. Collection now contains [1,1,2].
        randomizedCollection.getRandom(); // getRandom should:
        // - return 1 with probability 2/3, or
        // - return 2 with probability 1/3.
        randomizedCollection.remove(1);   // return true since the collection contains 1.
        // Removes 1 from the collection. Collection now contains [1,2].
        randomizedCollection.getRandom(); // getRandom should return 1 or 2, both equally likely.
    }
    /** Initialize your data structure here. */
    public RandomizedSet() {
        location = new HashMap<>();
        data = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(location.containsKey(val)){
            return false;
        }
        location.put(val, data.size());
        data.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!location.containsKey(val)){
            return false;
        }

        if(location.get(val) != data.size()-1){
            int loc = location.get(val);//location of val
            int tail = data.get(data.size()-1);//number of last
            //data.set(data.size()-1, data.get(loc));
            data.set(loc, tail);
            location.put(tail,loc);
        }

        location.remove(val);
        data.remove(data.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return data.get(rm.nextInt(data.size()));
    }
}
