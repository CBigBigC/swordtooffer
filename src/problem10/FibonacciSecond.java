package problem10;

/**
 * Using loop, the function is more efficient and avoid stack overflow
 */
public class FibonacciSecond {
    public static void main(String[] args) {
        System.out.println(nthOfFibonacci(30));
    }
    public static long nthOfFibonacci(int n){
        long num1 = 0;
        long num2 = 1;
        long result = 0;
        if(n == 1) return num1;
        if(n == 2) return num2;
        for(int i =2; i <= n; i ++){
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }
}
