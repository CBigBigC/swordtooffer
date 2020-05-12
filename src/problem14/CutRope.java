package problem14;

public class CutRope {
    public static void main(String[] args) {
        System.out.println(maxProduct(1065));
    }
    private static int maxProduct(int length){
        if(length == 0) return 0;
        if(length == 1) return 0;
        if(length == 2) return 1;
        if(length == 3) return 2;
        int[] product = new int[length + 1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        int max = 0;
        for(int i = 4; i <= length; i ++){
            for(int j = 1; j <= i/2; j ++){
                int temp = product[j] * product[i - j];
                max = Math.max(max, temp);
            }
            product[i] = max;
        }
        return product[length];
    }
}
