package problem28;

import java.util.ArrayList;
import java.util.List;

public class Symmetric {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(9);
        TreeNode d = new TreeNode(7);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
//        c.left = f;
//        c.right = g;
        System.out.println(isSymmetric(a));
    }
    private static boolean isSymmetric(TreeNode root){
        if(root == null) return false;
        List<Integer> preOrder = preOrder(root);
        List<Integer> fakePreOrder = fakePreOrder(root);
        for(int i = 0; i < preOrder.size(); i ++){
            if(!preOrder.get(i).equals(fakePreOrder.get(i))) return false;
        }
        return true;
    }
    private static List<Integer> preOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> preOrderAppend = new ArrayList<>();
        preOrderAppend.add(root.value);
        preOrderAppend.addAll(preOrder(root.left));
        preOrderAppend.addAll(preOrder(root.right));
        return preOrderAppend;
    }
    private static List<Integer> fakePreOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> fakePreOrderAppend = new ArrayList<>();
        fakePreOrderAppend.add(root.value);
        fakePreOrderAppend.addAll(fakePreOrder(root.right));
        fakePreOrderAppend.addAll(fakePreOrder(root.left));
        return fakePreOrderAppend;
    }
}
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int value) {
        this.value = value;
    }
}
