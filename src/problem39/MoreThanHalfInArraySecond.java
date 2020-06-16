package problem39;

import java.util.Random;

/**
 * Principle: According to sorting algorithm
 */
public class MoreThanHalfInArraySecond {
    public static void main(String[] args) {
        int[] testCase1 = {1,1,2,4,3,3,3};
        System.out.println(findMost(testCase1));
    }

    private static int findMost(int[] array) {
        if (array.length == 0) return Integer.MIN_VALUE;
        int begin = 0;
        int end = array.length - 1;
        int result = findMostCore(array, begin, end);
        return array[result];
    }

    private static int findMostCore(int[] array, int begin, int end) {
        if(begin >= end) return begin;
        int result = findMid(array, begin, end);
        if (result == array.length / 2) {
            return result;
        } else if (result >= array.length / 2) {
            end = result - 1;
            return findMostCore(array, begin, end);
        } else {
            begin = result + 1;
            return findMostCore(array, begin, end);
        }

    }

    private static int findMid(int[] array, int begin, int end) {
        Random random = new Random();
        int temp = random.nextInt(end - begin) + begin;
        array[end] = array[end] + array[temp];
        array[temp] = array[end] - array[temp];
        array[end] = array[end] - array[temp];
        int small = begin - 1;
        for(temp = begin; temp < end; temp ++){
            if(array[temp] < array[end]){
                small ++;
                if(small != temp){
                    array[end] = array[end] + array[temp];
                    array[temp] = array[end] - array[temp];
                    array[end] = array[end] - array[temp];
                }
            }
        }
        small ++;
        int tempValue = array[end];
        array[end] = array[temp];
        array[temp] = tempValue;
        return small;
    }
}
