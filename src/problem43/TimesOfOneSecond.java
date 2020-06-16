package problem43;

/**
 *
 */
public class TimesOfOneSecond {
    public static void main(String[] args) {
        System.out.println(timesOfOne(18632));
    }
    private static int timesOfOne(int n){
        if(n <= 0){
            return 0;
        }
        //Transfer the Integer into array
        char[] transfer = String.valueOf(n).toCharArray();
        int sum = 0;
        /**
         * For each digit, the appearance of '1' equals the product of all other digits' possibility
         * 13 for example: the time of appearance at first digit equals 4(0,1,2,3)
         */
        for(int i = 0; i < transfer.length; i ++){
            int numInCurrentDigit = 1;
            for(int j = 0; j < transfer.length; j ++){
                if(j != i){
                    numInCurrentDigit *= (transfer[j] - '0' + 1);
                }
            }
            sum += numInCurrentDigit;
        }
        return sum;
    }
}
