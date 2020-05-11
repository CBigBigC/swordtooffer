package problem9;

import java.util.Stack;

public class SimulateQueueWithTwoStack {
    public static void main(String[] args) {
        SimulatedQueue simulatedQueue = new SimulatedQueue();
        simulatedQueue.insert(1);
        simulatedQueue.insert(2);
        simulatedQueue.insert(3);
        simulatedQueue.insert(4);
        simulatedQueue.insert(5);
        simulatedQueue.insert(6);
        simulatedQueue.insert(7);
        int size = simulatedQueue.size;
        for(int i = 0; i < size; i ++){
            System.out.println(simulatedQueue.pop());
        }
    }
}
class SimulatedQueue{

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public int size = 0;

    //Stack1 as input collection
    public void insert(Integer i){
        stack1.push(i);
        size ++;
    }

    public Integer pop(){
        if(size <= 0) return null;
        //Transfer all the elements from stack1 to stack2, then all the sequence are reversed.
        //So if we pop stack2 now, the first element pushed to stack1 are now popped first.
        //That's "first in , first out" just like queue
        if(stack2.size() <= 0){
            int size1 = stack1.size();
            for(int i = 0; i < size1; i ++){
                stack2.push(stack1.pop());
            }
        }
        size --;
        return stack2.pop();
    }
}
