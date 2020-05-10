package problem3;

/**
 * Requirement: can't change the input array;
 * Advantage: Saving space
 * Time complexity: O(nlogn)
 * Space complexity: O(1);
 */
public class DuplicateNumberThird {
    public static void main(String[] args){
        int[] a = {4,5,7,6,1,2,3,7,8};
        try {
            System.out.println(findDuplication(a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int findDuplication(int[] array) throws Exception {
        if(array.length == 0){
            throw new Exception("Bad input");
        }
        return findDuplication(array, 1, array.length - 1);
    }
    public static int findDuplication(int[] array, int begin, int end) throws Exception {
        int mid = (begin + end)/2;
        int countLeft = 0;
        for(Integer i : array){
            if(i >= begin && i <= mid){
                countLeft ++;
            }
        }
        if(countLeft > mid - begin + 1){
            if(begin == end) return mid;
            return findDuplication(array, begin, mid);
        }else{
            countLeft = 0;
            for(Integer i : array){
                if(i > mid && i <= end){
                    countLeft ++;
                }
            }
            if(countLeft > end - mid){
                if(begin == end) return mid;
                return findDuplication(array, mid + 1, end);
            }
        }
        throw new Exception("Bad input");
    }
}
