package problem8;

public class NextNodeInPreOrderTraversal {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.father = a;
        c.father = a;

        b.left = d;
        b.right = e;
        d.father = b;
        e.father = b;

        c.left = f;
        c.right = g;
        f.father = c;
        g.father = c;

        e.left = h;
        e.right = i;
        h.father = e;
        i.father = e;

        System.out.println(findNextInPreOrderTraversal(g).value);

    }

    public static TreeNode findNextInPreOrderTraversal(TreeNode t) {
        if (t.hasRight()) return findFirstInTree(t.right);
        if (t.hasFather()) {
            if (t.father.hasLeft()) {
                if (t.father.left == t) {
                    return t.father;
                }
            }
            while (true) {
                if (!t.hasFather()) {
                    return null;
                } else if (t.isLeft()) {
                    return t.father;
                } else {
                    t = t.father;
                }
            }

        }
        return null;
    }

    private static TreeNode findFirstInTree(TreeNode root) {
        TreeNode temp = root;
        while (temp.hasLeft()) {
            temp = temp.left;
        }
        return temp;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode father;

    TreeNode(int value) {
        this.value = value;
    }

    boolean hasLeft() {
        return !(left == null);
    }

    boolean hasRight() {
        return !(right == null);
    }

    boolean hasFather() {
        return !(father == null);
    }

    boolean isLeft() {
        if (!hasFather()) {
            return false;
        }
        return this == this.father.left;
    }
}
