package problem3;

import java.util.HashSet;

/**
 * Duplicated number
 * Weakness: Need extra space: HashSet
 * Time complexity: O(n)
 * Space complexity: O(n);
 */
public class DuplicateNumberFirst {
    public int findDuplicated(int[] array) throws Exception {
        if(array.length == 0){
            throw new Exception("Bad input");
        }
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : array){
            if(set.contains(i)) return i;
            set.add(i);
        }
        throw new Exception("No duplication found");
    }
}
