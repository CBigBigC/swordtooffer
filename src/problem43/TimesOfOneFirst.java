package problem43;

/**
 * Brute force
 */
public class TimesOfOneFirst {
    public static void main(String[] args) {
        Long time1 = System.currentTimeMillis();
        System.out.println(timesOfNumberOne(18632));
        System.out.println(System.currentTimeMillis() - time1);
    }
    private static int timesOfNumberOne(int input){
        if(input <= 0) return 0;
        int sum = 0;
        for(int i = 1; i <= input; i ++){
            int current = i;
            while(current > 0){
                if(current % 10 == 1) sum ++;
                current /= 10;
            }
        }
        return sum;
    }
}
