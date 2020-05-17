package problem17;

public class Print1ToNDigitNumber {
    public static void main(String[] args) {
//        printString(1);
        char[] a = {'9', '7'};
        for(char i : a){
            i = '0';
            System.out.println(i);
        }
        for(char i : a){
            System.out.print(i);
        }
    }



    private static void printNumber(int n) {
        if (n < 10) {
            int max = (int) Math.pow((double) (10), (double) (n)) - 1;
            for (int i = 1; i <= max; i++) {
                System.out.println(i);
            }
        } else if (n < 19) {
            long max = (long) Math.pow((double) (10), (double) (n)) - 1;
            for (long i = 1; i <= max; i++) {
                System.out.println(i);
            }
        } else {
            printString(n);
        }

    }

    private static void printString(int n) {
        char[] result = new char[n];
        for(int i = 0; i <= result.length - 1; i ++){
            result[i] = '0';
        }
        while (valideOutput(result)) {
            autoAdd(result, result.length - 1);
            printArray(result);
        }
    }

    private static boolean valideOutput(char[] result) {
        boolean validation = true;
        for (char i : result) {
            validation &= (i == '9');
        }
        return !validation;
    }

    private static void printArray(char[] result) {
        int begin = 0;
        for (int i = 0; i <= result.length - 1; i++) {
            if (result[i] != '0') {
                begin = i;
                break;
            }
        }
        for (int i = begin; i <= result.length - 1; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

    private static void autoAdd(char[] result, int index) {
        if (index < 0) {
            return;
        }
        if (result[index] + 1 <= '9') {
            result[index] += 1;
        } else {
            result[index] = '0';
            autoAdd(result, index - 1);
        }
    }
}
