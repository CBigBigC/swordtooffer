package problem27;


public class MirrorBinaTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        getMirror(a);
        System.out.println(a.right.right.value);
    }
    private static TreeNode getMirror(TreeNode root){
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = getMirror(right);
        root.right = getMirror(left);
        return root;
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