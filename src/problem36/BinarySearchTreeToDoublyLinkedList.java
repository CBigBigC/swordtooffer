package problem36;

public class BinarySearchTreeToDoublyLinkedList {
    public static void main(String[] args) {
        BinarySearchTreeNode a = new BinarySearchTreeNode(4);
        BinarySearchTreeNode b = new BinarySearchTreeNode(2);
        BinarySearchTreeNode c = new BinarySearchTreeNode(5);
        BinarySearchTreeNode d = new BinarySearchTreeNode(1);
        BinarySearchTreeNode e = new BinarySearchTreeNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        DoublyLinkedListNode result = transfer(a, true);
        System.out.println(result.value);
    }
    private static DoublyLinkedListNode transfer(BinarySearchTreeNode root, boolean isLeft){
        if(root == null) return null;
        DoublyLinkedListNode midNode = new DoublyLinkedListNode(root.value);
        if(root.left != null){
            DoublyLinkedListNode temp = transfer(root.left, true);
            midNode.prior = temp;
            temp.next = midNode;
        }

        if(root.right != null){
            DoublyLinkedListNode temp = transfer(root.right, false);
            midNode.next = temp;
            temp.prior = midNode;
        }
        //左子树返回最右节点（最大），右子树返回最左（最小）
        if(isLeft){
            while(midNode.next != null) midNode = midNode.next;
        }else {
            while(midNode.prior != null) midNode = midNode.prior;
        }
        return midNode;
    }
}
class BinarySearchTreeNode{
    int value;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;
    BinarySearchTreeNode(){};
    BinarySearchTreeNode(int value){
        this.value = value;
    }
}
class DoublyLinkedListNode{
    int value;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prior;
    DoublyLinkedListNode(){};
    DoublyLinkedListNode(int value){
        this.value = value;
    }
}
