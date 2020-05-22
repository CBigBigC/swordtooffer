package problem32;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PrintTree line by line
 */
public class BinaryTreePrintByLine {
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
        printByLine(a);
    }

    private static void printByLine(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLineLeft = 1;
        int nextLineCount = 0;
        while (queue.size() > 0) {
            while (currentLineLeft > 0) {
                System.out.print(queue.peek().value + " ");
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                    nextLineCount++;
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                    nextLineCount++;
                }
                queue.poll();
                currentLineLeft--;
            }
            System.out.println();
            currentLineLeft = nextLineCount;
            nextLineCount = 0;
        }
    }
}
