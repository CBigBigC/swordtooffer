package problem30;

import java.util.Stack;

public class StackWithMin {
    public static void main(String[] args) throws Exception {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(4);
        stackWithMin.push(5);
        stackWithMin.push(3);
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
    }
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> subStack = new Stack<>();
    public void push(int toBePushed){
        dataStack.add(toBePushed);
        if(subStack.size() <= 0){
            subStack.add(toBePushed);
        }else if(subStack.peek() > toBePushed){
            subStack.add(toBePushed);
        }else {
            subStack.add(subStack.peek());
        }
    }
    public void pop(){
        if(dataStack.empty()) return;
        subStack.pop();
        dataStack.pop();
    }
    public int min() throws Exception {
        if(dataStack.empty()) {
            throw new Exception();
        }
        return subStack.peek();
    }
}
