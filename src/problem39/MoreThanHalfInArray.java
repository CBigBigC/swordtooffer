package problem39;

import java.util.Arrays;

/**
 * Sort the array first, and then find the component within a loop
 * Drawback: time complex is nlogn
 */
public class MoreThanHalfInArray {
    public static void main(String[] args) {
        int[] testCase1 = {1,1};
        System.out.println(findMost(testCase1));
    }
    private static int findMost(int[] array){
        if(array.length == 0) return Integer.MIN_VALUE;
        //时间复杂度 nlogn
        Arrays.sort(array);
        int result = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i ++){
            while(i < array.length){
                if(result == array[i]){
                    count ++;
                    i ++;
                }
            }
            if(count > array.length/2) {
                return result;
            }else if(i < array.length){
                result = array[i];
                count = 1;
            }
        }
        return Integer.MIN_VALUE;
    }
}
