package problem9;

import java.util.LinkedList;
import java.util.Queue;

public class SimulateStackWithTwoQueue {
    public static void main(String[] args) {
        SimulatedStack simulatedStack = new SimulatedStack();
        simulatedStack.push(1);
        simulatedStack.push(6);
        simulatedStack.push(3);
        simulatedStack.push(7);
        simulatedStack.push(5);
        simulatedStack.push(45);
        simulatedStack.push(74);
        int size = simulatedStack.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(simulatedStack.pop());
        }
    }
}

class SimulatedStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public int getSize() {
        return size;
    }

    private int size = 0;

    //Queue1 as input collection
    public void push(Integer i) {
        if (queue1.size() <= 0) {
            queue2.add(i);
        } else {
            queue1.add(i);
        }
        size++;
    }

    public Integer pop() {
        if (size <= 0) return null;
        if (queue2.size() <= 0) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.add(queue1.remove());
            }
            this.size--;
            return queue1.remove();
        } else {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.add(queue2.remove());
            }
            this.size--;
            return queue2.remove();
        }
    }
}
