package problem39;

public class MoreThanHalfInArrayThird {
    public static void main(String[] args) {
        int[] testCase1 = {1,1,2,41,3,3,3};
        System.out.println(findMost(testCase1));
    }
    private static int findMost(int[] array) {
        if (array.length == 0) return Integer.MIN_VALUE;
        int current = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i ++){
            if(array[i] == current){
                count ++;
            }else if(count == 0){
                current = array[i];
                count ++;
            }else {
                count --;
            }
        }
        if(count > 0 && isMoreThanHalf(array, current)){
            return current;
        }else {
            return Integer.MIN_VALUE;
        }
    }
    private static boolean isMoreThanHalf(int[] array, int target){
        int count = 0;
        for(int i = 0; i < array.length; i ++){
            if(target == array[i]) count ++;
        }
        return count > array.length/2;
    }
}
