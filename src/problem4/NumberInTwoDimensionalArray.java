package problem4;

/**
 * recursion
 */
public class NumberInTwoDimensionalArray {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,7},{2,8,9,10},{4,9,11,14},{8,11,14,16}};
        System.out.println(hasNumber(a, 17));
    }

    public static boolean hasNumber(int[][] array, int a){
        if(array[0].length == 0) return false;
        return hasNumber(array, a, 0, array[0].length - 1);
    }
    public static boolean hasNumber(int[][] array, int a, int row, int column){
        if(column < 0 || row > array.length - 1) return false;
        if(a == array[row][column]){
            return true;
        }else if(a < array[row][column]){
            return hasNumber(array, a, row, column - 1);
        }else{
            return hasNumber(array, a, row + 1, column);
        }
    }
}
