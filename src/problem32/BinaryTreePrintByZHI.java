package problem32;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Print BinaryTree by 之（左右交替）
 */
public class BinaryTreePrintByZHI {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        printByLine(a);
    }
    private static void printByLine(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLineLeft = 1;
        int nextLineCount = 0;
        int level = 1;
        while(queue.size() > 0){
            //For each level, create a stack/queue according to the need
            Stack<TreeNode> innerStack = new Stack<>();
            Queue<TreeNode> innerQueue = new LinkedList<>();
            while(currentLineLeft > 0){
                if(queue.peek().left != null) {
                    queue.add(queue.peek().left);
                    nextLineCount ++;
                }
                if(queue.peek().right != null) {
                    queue.add(queue.peek().right);
                    nextLineCount ++;
                }
                //put data into container
                if(level%2 != 0){
                    innerStack.add(queue.poll());
                }else {
                    innerQueue.add(queue.poll());
                }
                currentLineLeft --;
            }
            //print container
            if(level%2 != 0){
                while(!innerStack.empty()){
                    System.out.print(innerStack.pop().value + " ");
                }
            }else {
                while(innerQueue.size() > 0){
                    System.out.print(innerQueue.poll().value + " ");
                }
            }
            System.out.println();
            currentLineLeft = nextLineCount;
            nextLineCount = 0;
            level ++;
        }
    }
}
