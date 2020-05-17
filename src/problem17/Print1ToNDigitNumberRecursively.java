package problem17;

public class Print1ToNDigitNumberRecursively {
    private void print(int n){
        if(n <= 0) return;
        char[] result = new char[n];
        for(int i = 0; i < result.length; i ++){
            result[i] = '0';
        }
        for(int i = 0; i < 10; i ++){
            result[0] = (char)('0' + i);
            printRecursively(result, n, 0);
        }
    }

    private void printRecursively(char[] a, int n, int index ) {
        if(index == n - 1){
            printArray(a);
            return;
        }
        for(int i = 0; i < 10; i ++){
            a[index + 1] = (char)('0' + i);
            printRecursively(a, n, index + 1);
        }
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
}
