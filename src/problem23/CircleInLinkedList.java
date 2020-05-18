package problem23;

public class CircleInLinkedList {
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
        f.next = c;
        System.out.println(findEntranceOfCircle(a).value);
    }
    private static LinkedNode findEntranceOfCircle(LinkedNode head){
        if(head == null) return null;
        if(!hasCircle(head)) return null;
        return findEntrance(head);
    }

    private static LinkedNode findEntrance(LinkedNode head) {
        LinkedNode first = head, second = head;
        int lengthOfCircle = 0;
        while(true){
            first = first.next;
            second = second.next.next;
            lengthOfCircle ++;
            if(first == second){
                break;
            }
        }
        first = head;
        second = head;
        while(lengthOfCircle > 0){
            first = first.next;
            lengthOfCircle --;
        }
        while (true){
            first = first.next;
            second = second.next;
            if(first == second){
                return first;
            }
        }
    }

    private static boolean hasCircle(LinkedNode head) {
        LinkedNode first = head, second = head;
        while(first.hasNext() && second.hasNext()){
            first = first.next;
            second = second.next;
            if(second.hasNext()){
                second = second.next;
            }else {
                return false;
            }
            if(first == second){
                return true;
            }
        }
        return false;
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
