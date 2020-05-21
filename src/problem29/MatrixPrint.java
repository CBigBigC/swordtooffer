package problem29;

/**
 * weakness：Extra storage：boolean[][] visited;
 */
public class MatrixPrint {
    public static void main(String[] args) {
        int[][] matrix = {{1},{2},{3}};
        printMatrix(matrix);
    }
   private static void printMatrix(int[][] matrix){
       boolean[][] visited = new boolean[matrix.length][matrix[0].length];
       for(int i = 0;; i ++){
           if(visited[i][i]) break;
           if(isSurrounded(i, visited)) {
               visited[i][i] = true;
               System.out.println(matrix[i][i]);
               break;
           }
           //起始位置
           int x = i, y = i;
           //向右打印
           while(y < matrix[0].length){
               if(visited[x][y]) break;

               visited[x][y] = true;
               System.out.println(matrix[x][y]);
               y ++;
           }
           //更新起始点
           x ++;
           y --;
           //向下走越界，即可返回
           if(x >= matrix.length) break;
           //向下打印
           while(x < matrix.length){
               if(visited[x][y]) break;
               visited[x][y] = true;
               System.out.println(matrix[x][y]);
               x ++;
           }
           //更新起始点
           x --;
           y --;
           //向左走越界，即可返回
           if(y < 0) break;
           while(y >= 0){
               if(visited[x][y]) break;
               visited[x][y] = true;
               System.out.println(matrix[x][y]);
               y --;
           }
           x --;
           y ++;
           if(x < 0) break;
           while(x >= 0){
               if(visited[x][y]) break;
               visited[x][y] = true;
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
