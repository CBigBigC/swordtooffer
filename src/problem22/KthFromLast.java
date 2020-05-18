package problem22;

//Traversal needed(twice)
public class KthFromLast {
    public static void main(String[] args) {
        LinkedNode a = new LinkedNode(1);
        LinkedNode b = new LinkedNode(2);
        LinkedNode c = new LinkedNode(3);
        LinkedNode d = new LinkedNode(4);
        LinkedNode e = new LinkedNode(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
        System.out.println(kthFromLast(a,1).value);
    }
    private static LinkedNode kthFromLast(LinkedNode head, int k) {
        if (head == null) {
            return null;
        }
        LinkedNode temp = head;
        int count = 1;
        while(temp.hasNext()){
            count ++;
            temp = temp.next;
        }
        if(count < k) return null;
        temp = head;
        for(int i = 1; i <= count - k; i ++){
            temp = temp.next;
        }
        return temp;
    }
}

class LinkedNode {
    int value;
    LinkedNode next;

    LinkedNode(int value) {
        this.value = value;
    }

    boolean hasNext() {
        return next != null;
    }
}

