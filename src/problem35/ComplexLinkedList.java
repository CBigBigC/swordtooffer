package problem35;

public class ComplexLinkedList {
    /**
     * 1: Make a copy of the list first, then add the siblings.
     * 2: Make a copy first, put the pair into one map in the mean time, then add the siblings.
     * 3: Make a copy of each node, which will be added at the end of the origin one.
     */
    //TODO:
}
class ComplexLinkedNode{
    int value;
    ComplexLinkedNode next;
    ComplexLinkedNode sibling;
    boolean hasNext(){
        return next != null;
    }
}
