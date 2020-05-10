package problem3;

import java.util.HashSet;

/**
 * Duplicated number
 * Advantage: No extra space usage;
 * Because the array is 0~n-1, basically, it's like '0 1 2 3 4 5 6' after being sorted
 * and maybe '0 1 2 2 3 4 5'
 *
 * Time complexity: O(n)
 * Space complexity: O(1);
 */
public class DuplicateNumberSecond {
    public int findDuplicated(int[] array) throws Exception {
        int len = array.length;
        if (array.length <= 0) throw new Exception("No duplication found");
        for (int i = 0; i < len; len++) {
             if(array[i] != i){
                 if(array[array[i]] == array[i]) return array[i];
                 array[array[i]] = array[array[i]] + array[i];
                 array[i] = array[array[i]] - array[i];
                 array[array[i]] = array[array[i]] - array[i];
                 i --;
             }
        }
        //The time complexity may looks like O(n2), but actually it's O(n)
        // because for each number, they will be at the right position within two swamp
        throw new Exception("No duplication found");
    }
}
