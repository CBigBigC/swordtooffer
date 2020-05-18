package problem25;

public class CombineTwoOrderedList {
    public static void main(String[] args) {
        LinkedNode a = new LinkedNode(1);
        LinkedNode b = new LinkedNode(2);
        LinkedNode c = new LinkedNode(3);
        LinkedNode d = new LinkedNode(4);
        LinkedNode e = new LinkedNode(5);
        LinkedNode f = new LinkedNode(6);
        a.next = c;
        b.next = d;
        c.next = e;
        d.next = f;
        LinkedNode result = combination(a, b);
        while(result != null){
            System.out.println(result.value);
            result = result.next;
        }
    }
    private static LinkedNode combination(LinkedNode first, LinkedNode second) {
        if (first == null && second == null) return null;
        LinkedNode head = new LinkedNode();
        head.next = first.value < second.value ? first : second;
        LinkedNode temp = head;
        while (true) {
            if(first == null){
                temp.next = second;
                break;
            }
            if(second == null){
                temp.next = first;
                break;
            }
            if(first.value < second.value){
                temp.next = first;
                first = first.next;
            }else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }

        return head.next;
    }
}

class LinkedNode {
    int value;
    LinkedNode next;

    LinkedNode(){};
    LinkedNode(int value) {
        this.value = value;
    }

    boolean hasNext() {
        return next != null;
    }
}