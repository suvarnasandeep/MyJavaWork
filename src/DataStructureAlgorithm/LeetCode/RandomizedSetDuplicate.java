package DataStructureAlgorithm.LeetCode;

import java.util.*;

/*
    Insert Delete GetRandom O(1)
    Design a data structure that supports all following operations in average O(1) time.(Duplicate allowed)

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom(): Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
public class RandomizedSetDuplicate {

    /** Initialize your data structure here. */
    List<Integer> numbers;
    Map<Integer, Set<Integer>> map;
    Random random;

    public RandomizedSetDuplicate() {
        numbers = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public static void main(String[] args) {
        RandomizedSetDuplicate randomizedCollection = new RandomizedSetDuplicate();
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
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }

        int size = numbers.size();
        numbers.add(val);
        map.get(val).add(size);

        if (map.get(val).size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Set<Integer> set = map.get(val);
        Optional<Integer> removeIndex = set.stream().findAny();
        if (!removeIndex.isPresent()) {
            map.remove(val);
            return false;
        }

        int removeIndexInteger = removeIndex.get();
        if (removeIndexInteger < numbers.size() - 1) {
            int size = numbers.size();
            int lastNumber = numbers.get(size - 1);

            numbers.set(removeIndexInteger, lastNumber);

            map.get(val).remove(removeIndexInteger);
            map.get(lastNumber).remove(size - 1);
            map.get(lastNumber).add(removeIndexInteger);

            numbers.remove(numbers.size() - 1);
        } else {

            numbers.remove(numbers.size() - 1);
            map.get(val).remove(removeIndexInteger);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return numbers.get(random.nextInt(numbers.size()));
    }
}
