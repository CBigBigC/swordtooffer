package problem37;

import java.util.ArrayList;
import java.util.List;

public class SerializeBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(1);
        BinaryTreeNode b = new BinaryTreeNode(2);
        BinaryTreeNode c = new BinaryTreeNode(3);
        BinaryTreeNode d = new BinaryTreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        List<String> result = serialization(a);
        for (String i : result) {
            System.out.print(i + ",");
        }
    }

    private static List<String> serialization(BinaryTreeNode root) {
        if (root == null) return null;
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(root.value));
        if (root.left != null) {
            result.addAll(serialization(root.left));
        } else {
            result.add("$");
        }
        if (root.right != null) {
            result.addAll(serialization(root.right));
        } else {
            result.add("$");
        }
        return result;
    }
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode() {
    }

    BinaryTreeNode(int value) {
        this.value = value;
    }
}

