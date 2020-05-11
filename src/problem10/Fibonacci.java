package problem10;

/**
 * Weakness: duplicated calculation: 5th will need 4th and 3th, while 4th also need 3th
 * thus it is computed twice. That's a waste of resources.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(nthOfFibonacci(30));
    }
    public static int nthOfFibonacci(int n){
        if(n == 1) return 0;
        if(n == 2) return 1;
        return nthOfFibonacci(n - 1) + nthOfFibonacci(n - 2);
    }
}
