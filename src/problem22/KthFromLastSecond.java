package problem22;

//Traversal needed(once)
public class KthFromLastSecond {

    public static void main(String[] args) {
        LinkedNode a = new LinkedNode(1);
        LinkedNode b = new LinkedNode(2);
        LinkedNode c = new LinkedNode(3);
        LinkedNode d = new LinkedNode(4);
        LinkedNode e = new LinkedNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(kthFromLast(a,7).value);
    }
    private static LinkedNode kthFromLast(LinkedNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        LinkedNode temp = head;
        int count = 1;
        while(count <= k - 1){
            if(!temp.hasNext()) return new LinkedNode(-1);
            count ++;
            temp = temp.next;
        }
        int count2 = 1;
        LinkedNode temp2 = head;
        while(temp.hasNext()){
            temp = temp.next;
            temp2 = temp2.next;
            count ++;
            count2 ++;
        }
        return temp2;
    }
}
