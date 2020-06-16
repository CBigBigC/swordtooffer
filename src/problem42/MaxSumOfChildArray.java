package problem42;

public class MaxSumOfChildArray {
    public static void main(String[] args) {
        int[] a = {-1,-1,-3,4,-1,5};
        System.out.println(maxSum(a));
    }
    private static int maxSum(int[] arr){
        if(arr != null){
           int currentSum = 0;
           int maxSum = Integer.MIN_VALUE;
           for(int i = 0; i < arr.length; i ++){
               if(currentSum <= 0){
                   currentSum = arr[i];
               }else{
                   currentSum += arr[i];
                   maxSum = maxSum > currentSum ? maxSum : currentSum;
               }
           }
           return maxSum;
        }
        return Integer.MIN_VALUE;
    }
}
