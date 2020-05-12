package problem13;

public class RangeOfRobot {
    public static void main(String[] args) {
        System.out.println(numberOfRange(30,30));
    }
    private static int numberOfRange(int row, int column) {
        boolean matrix[][] = new boolean[row][column];
        traversal(row, column, 0, 0, matrix);
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j]) count++;
            }
        }
        return count;
    }

    private static void traversal(int row, int column, int x, int y, boolean[][] matrix) {
        if (x >= 0 && x < row && y >= 0 && y < column) {
            if (!matrix[x][y]) {
                if (reachable(x, y)){
                    matrix[x][y] = true;
                    traversal(row, column, x - 1, y, matrix);
                    traversal(row, column, x + 1, y, matrix);
                    traversal(row, column, x, y - 1, matrix);
                    traversal(row, column, x, y + 1, matrix);
                }else {
                    System.out.println(x + "+" + y);
                }
            }
        }
    }

    private static boolean reachable(int x, int y) {
        int result = 0;
        while (x > 0) {
            result += x % 10;
            x /= 10;
        }
        while (y > 0) {
            result += y % 10;
            y /= 10;
        }
        return result <= 18;
    }
}
