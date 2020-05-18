package problem26;

public class IsChildTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);

        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        TreeNode j = new TreeNode(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = f;
        d.right = g;
        h.left = i;
        h.right = j;

        System.out.println(isChildTree(a, h));


    }

    private static boolean isChildTree(TreeNode father, TreeNode child) {
        if (father == null || child == null) return false;
        //TODO: 遍历比较
        if (comparation(father, child)) return true;
        //左右树的比较
        boolean leftIsChild = false, rightIsChild = false;

        if (father.left != null) {
            leftIsChild = isChildTree(father.left, child);
        }
        if (father.right != null) {
            rightIsChild = isChildTree(father.right, child);
        }

        return leftIsChild || rightIsChild;
    }

    //遍历比较
    private static boolean comparation(TreeNode father, TreeNode child) {
        if (father.value != child.value) return false;
        if (child.left == null && child.right == null) return true;
        boolean leftIsEqual = false, rightIsEqual = false;
        if (child.left != null) {
            if (father.left != null) {
                leftIsEqual = comparation(father.left, child.left);
            } else {
                return false;
            }
        }
        if (child.right != null) {
            if (father.right != null) {
                rightIsEqual = comparation(father.right, child.right);
            } else {
                return false;
            }
        }
        return leftIsEqual && rightIsEqual;
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
