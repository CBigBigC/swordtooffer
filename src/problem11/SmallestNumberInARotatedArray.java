package problem11;

public class SmallestNumberInARotatedArray {
    public static void main(String[] args) {
        int[] a = {1,0,1,1,1};
        System.out.println(findSmallest(a));
    }
    public static int findSmallest(int[] array){
        int len = array.length;
        if(len == 0) return -1;
        int left = 0;
        int right = len - 1;
        return findSmallestCore(array, left, right);
    }

    private static int findSmallestCore(int[] array, int left, int right) {
        if(right - left == 1){
            if(array[right] < array[left]){
                return array[right];
            }else{
                return array[0];
            }
        }
        int mid = (left + right)/2;
        if(array[left] == array[right] && array[left] == array[mid]){
            return findSmallestSequence(array, left, right);
        }
        if(array[left] < array[mid]){
            return findSmallestCore(array, mid, right);
        }else{
            return findSmallestCore(array, left, mid);
        }
    }

    private static int findSmallestSequence(int[] array, int left, int right) {
        int result = array[left];
        for(int i = left; i <= right; i ++){
            if(result > array[i]) result = array[i];
        }
        return result;
    }
}
