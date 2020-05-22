package problem32;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(4);
        a.left = b;
        a.right = c;
        c.right = d;
        d.right = e;
        e.right = f;
        printTreeBreathFirst(a);
    }
    private static void printTreeBreathFirst(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            System.out.println(queue.peek().value);
            if(queue.peek().left != null) queue.add(queue.peek().left);
            if(queue.peek().right != null) queue.add(queue.peek().right);
            queue.poll();
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

