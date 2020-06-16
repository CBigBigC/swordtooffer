package problem44;

public class NthInNumberSeries {
    public static void main(String[] args) {
        System.out.println(findNum(192));
    }

    private static int findNum(int n){
        if(n < 0) return Integer.MIN_VALUE;
        if(n <= 9) return n;
        n -= 9;
        int temp;
        for(int i = 2; ; i ++){
            if(n <= (9 * (int)Math.pow(10, i - 1) * i)){
                temp = i;
                break;
            }
            n -= (9 * (int)Math.pow(10, i - 1) * i);
        }
        int base = (int)Math.pow(10, temp - 1) - 1;
        int bigOffset = (n - 1)/temp + 1;
        int baseNumber = base + bigOffset;
        int offset = n % temp;
        if(offset == 0) offset = temp;
        for(int i = 1; i <= temp - offset; i ++){
            baseNumber /= 10;
        }
        baseNumber %= 10;
        return baseNumber;
    }
}
