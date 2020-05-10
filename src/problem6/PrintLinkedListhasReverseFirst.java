package problem6;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Using stack
 */
public class PrintLinkedListhasReverseFirst {
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
        if (target != null){
            Stack<LinkedNode> stack = new Stack<>();
            while(target != null){
                stack.push(target);
                target = target.next;
            }
            while(!stack.empty()){
                System.out.println(stack.pop().value);
            }
        }
    }
}
class LinkedNode{
    public int value;
    public LinkedNode next;
    public LinkedNode(int value){
        this.value = value;
    }
}
