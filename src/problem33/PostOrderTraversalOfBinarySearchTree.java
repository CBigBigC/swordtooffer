package problem33;

public class PostOrderTraversalOfBinarySearchTree {
    public static void main(String[] args) {
        int[] test = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(isPostOrder(test));
    }

    private static boolean isPostOrder(int[] array) {
        if (array == null) return false;
        int len = array.length;
        if (len == 0) return false;
        return isPostOrderCore(array, 0, len - 2, array[len - 1]);
    }

    private static boolean isPostOrderCore(int[] array, int start, int end, int root) {
        if (start >= end) return true;
        int temp = -1;
        for (int i = start; i <= end; i++) {
            if (array[i] > root) {
                temp = i;
                break;
            }
        }
        if (temp == -1) {
            return true;
        } else {
            for (int i = temp; i <= end; i++) {
                if (array[i] < root) {
                    return false;
                }
            }
        }
        return isPostOrderCore(array, start, temp - 2, array[temp - 1]) &&
                isPostOrderCore(array, temp, end - 1, array[end]);
    }
}
