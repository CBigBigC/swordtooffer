package problem7;


public class BinaryTreeRebuild {

    public static void main(String[] args) {
        int[] a = {1,2,4,7,3,5,6,8};
        int[] b = {4,7,2,1,5,3,8,6};
        TreeNode root = rebuildTree(a,b);
        inOrderTraversal(root);

    }

    public static TreeNode rebuildTree(int[] firstArray, int[] midArray){
        int len = firstArray.length;
        if(len == 0 || midArray.length != len){
            return null;
        }
        return findNextRoot(firstArray, midArray, 0, len - 1, 0, len -1);

    }
    public static TreeNode findNextRoot(int[] firstArray, int[] midArray, int index1, int index2, int index3, int index4){
        if(index1 == index2){
            TreeNode root = new TreeNode();
            root.value = firstArray[index1];
            return root;
        }
        TreeNode root = new TreeNode();
        int mid = findIndex(midArray, firstArray[index1]);
        int leftIndex1 = index1 + 1;
        int leftIndex2 = leftIndex1 + mid - index3 - 1;
        int leftIndex3 = index3;
        int leftIndex4 = mid - 1;
        int rightIndex1 = leftIndex2 + 1;
        int rightIndex2 = index2;
        int rightIndex3 = mid + 1;
        int rightIndex4 = index4;
        root.value = firstArray[index1];
        if(leftIndex1 <= leftIndex2){
            root.left = findNextRoot(firstArray, midArray, leftIndex1, leftIndex2, leftIndex3, leftIndex4);
        }
        if(rightIndex1 <= rightIndex2){
            root.right = findNextRoot(firstArray, midArray, rightIndex1, rightIndex2, rightIndex3, rightIndex4);
        }
        return root;
    }
    public static int findIndex(int[] array, int target){
        for(int i = 0; i < array.length; i ++){
            if(array[i] == target) return i;
        }
        return -1;
    }

    public static void inOrderTraversal(TreeNode root){
        if(root != null){
            System.out.println(root.value);
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }
    }
}
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
}
