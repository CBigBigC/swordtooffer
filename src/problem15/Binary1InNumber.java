package problem15;

public class Binary1InNumber {
    public static void main(String[] args) {
        System.out.println(numberOf1(-8));
    }
    private static int numberOf1(int n){
        int count = 0;
        while(n != 0){
            ++ count;
            n = (n - 1)&n;
        }
        return count;
    }
}
