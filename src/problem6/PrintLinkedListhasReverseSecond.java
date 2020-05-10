package problem6;

import java.util.Stack;

/**
 * Using recursion
 * Weakness: May cause stack overflow when the calling stack is very deep;
 */
public class PrintLinkedListhasReverseSecond {
    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(7);
        LinkedNode first = head;
        first.next = new LinkedNode(5);
        first = first.next;
        first.next = new LinkedNode(4);
        first = first.next;
        first.next = new LinkedNode(6);
        first = first.next;
        first.next = new LinkedNode(2);
        first = first.next;
        first.next = new LinkedNode(9);
        first = first.next;
        printList(head);
    }
    public static void printList(LinkedNode target){
        if(target!= null){
            if(target.next != null){
                printList(target.next);
                System.out.println(target.value);
            }else{
                System.out.println(target.value);
            }
        }
    }
}
