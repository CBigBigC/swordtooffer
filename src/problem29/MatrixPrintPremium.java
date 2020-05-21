package problem29;

/**
 * weakness：Extra storage：boolean[][] visited;
 */
public class MatrixPrintPremium {
    public static void main(String[] args) {
        int[][] matrix = {{1,2},{2,4},{3,6}};
        printMatrix(matrix);
    }
    private static void printMatrix(int[][] matrix){
        for(int i = 0;; i ++){
            if(i * 2 >= matrix[0].length || i * 2 >= matrix.length) break;
            //起始位置
            int x = i, y = i;
            //向右打印
            while(y < matrix[0].length - i){
                System.out.println(matrix[x][y]);
                y ++;
            }
            //更新起始点
            x ++;
            y --;
            //向下走越界，即可返回
            if(x >= matrix.length - i) break;
            //向下打印
            while(x < matrix.length - i){
                System.out.println(matrix[x][y]);
                x ++;
            }
            //更新起始点
            x --;
            y --;
            //向左走越界，即可返回
            if(y < i) break;
            while(y >= i){
                System.out.println(matrix[x][y]);
                y --;
            }
            x --;
            y ++;
            if(x < i) break;
            while(x > i){
                System.out.println(matrix[x][y]);
                x --;
            }
        }
    }

    private static boolean isSurrounded(int i, boolean[][] visited) {
        boolean rightIsWall = false;
        boolean downIsWall = false;
        boolean rightIsVisited = false;
        boolean downIsVisited = false;
        if(i + 1 >= visited[0].length) {
            rightIsWall = true;
        }else{
            rightIsVisited = visited[i][i + 1];
        }
        if(i + 1 >= visited.length) {
            downIsWall = true;
        }else{
            downIsVisited = visited[i + 1][i];
        }
        return (rightIsWall || rightIsVisited) && (downIsWall || downIsVisited);
    }
}
