package problem34;

import java.util.*;

public class PathInBinaryTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b= new TreeNode(2);
        TreeNode c = new TreeNode(2);
        a.left = b;
        a.right = c;
        printPath(a, 3);
    }
    private static void printPath(TreeNode root, int target){
        if(root != null){
            Vector<TreeNode> currentPath = new Vector<>();
            int currentValue = 0;
            printCore(root, currentPath, target, currentValue);
        }
    }

    private static void printCore(TreeNode root, Vector<TreeNode> currentPath, int target, int currentValue) {
        if(root == null) return;
        currentPath.add(root);
        currentValue += root.value;
        if (currentValue == target){
            if(root.left != null || root.right != null) return;
            for(int i = 0; i < currentPath.size(); i ++){
                System.out.print(currentPath.elementAt(i).value + " ");
            }
            System.out.println();
            currentPath.remove(currentPath.size() - 1);
        }else{
            printCore(root.left, currentPath, target, currentValue);
            printCore(root.right, currentPath, target, currentValue);
        }
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.value = value;
    }
}
