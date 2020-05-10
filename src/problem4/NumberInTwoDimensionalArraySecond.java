package problem4;

/**
 * loop
 */
public class NumberInTwoDimensionalArraySecond {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,7},
                     {2,8,9,10},
                     {4,9,11,14},
                     {8,11,14,16}};
        System.out.println(hasNumber(a, 422));
    }

    private static boolean hasNumber(int[][] array, int a){
        if(array[0].length == 0) return false;
        return hasNumberDouble(array, a, 0, array[0].length - 1);
    }
    private static boolean hasNumberDouble(int[][] array, int a, int row, int column){
        while(column >= 0 && row <= array.length - 1){
            if(a == array[row][column]){
                return true;
            }else if(a < array[row][column]){
                column --;
            }else{
                row ++;
            }
        }
        return false;
    }
}
