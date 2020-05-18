package problem24;


public class ReverseList {
    public static void main(String[] args) {
        LinkedNode a = new LinkedNode(1);
        LinkedNode b = new LinkedNode(2);
        LinkedNode c = new LinkedNode(3);
        LinkedNode d = new LinkedNode(4);
        LinkedNode e = new LinkedNode(5);
        LinkedNode f = new LinkedNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        reverseLinkedList(a);
        System.out.println(a.next.value);
    }

    private static LinkedNode reverseLinkedList(LinkedNode head) {
        if (head == null) {
            return null;
        }
        if (!head.hasNext()) {
            return head;
        }
        LinkedNode last = null;
        LinkedNode first = head;
        LinkedNode second = head.next;
        if (!second.hasNext()) {
            first.next = null;
            second.next = first;
            return second;
        } else {
            LinkedNode third = second.next;
            while (third != null){
                first.next = last;
                second.next = first;
                last = first;
                first = second;
                second = third;
                third = third.next;
            }
            second.next = first;
            return second;
        }
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
