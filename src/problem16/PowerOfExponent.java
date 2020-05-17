package problem16;

public class PowerOfExponent {

    public static void main(String[] args) {
        System.out.println(powerOfExponent(3.1, -4));
    }
    private static double powerOfExponent(double base, int exponent){
        if(base == 0.0 && exponent == 0){
            return 0.0;
        }
        if(base != 0.0 && exponent == 0) return 1;
        if(exponent < 0){
            exponent *= (-1);
            for(int i = 1; i <= exponent; i ++){
                base *= base;
            }
            return 1/base;
        }else{
            for(int i = 1; i <= exponent; i ++){
                base *= base;
            }
            return base;
        }
    }
}
