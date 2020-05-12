package problem12;

public class PathInMatrix {
    public static void main(String[] args) {
        char[][] a = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        System.out.println(hasPath(a, "abfb"));
    }

    private static boolean hasPath(char[][] matrix, String target) {
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;
        int pathLength = 0;
        boolean reachMatrix[][] = new boolean[rowNum][columnNum];
        for (int row = 0; row < rowNum; row++) {
            for (int column = 0; column < columnNum; column++) {
                if (hasPathCore(matrix, reachMatrix, target, row, column, rowNum, columnNum, pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] matrix,
                                       boolean[][] reachMatrix,
                                       String target,
                                       int row,
                                       int column,
                                       int rowNum,
                                       int columnNum,
                                       int pathLength) {
        if(pathLength == 4){
            return true;
        }
        if (row >= 0
                && row < rowNum
                && column >= 0
                && column < columnNum) {
            if(!reachMatrix[row][column]
                    &&   matrix[row][column] == target.charAt(pathLength)){
                pathLength++;
                reachMatrix[row][column] = true;
                if (!(hasPathCore(matrix, reachMatrix, target, row + 1, column, rowNum, columnNum, pathLength)
                        || hasPathCore(matrix, reachMatrix, target, row - 1, column, rowNum, columnNum, pathLength)
                        || hasPathCore(matrix, reachMatrix, target, row, column + 1, rowNum, columnNum, pathLength)
                        || hasPathCore(matrix, reachMatrix, target, row, column - 1, rowNum, columnNum, pathLength))) {
                    pathLength--;
                    reachMatrix[row][column] = false;
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
