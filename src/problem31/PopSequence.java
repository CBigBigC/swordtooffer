package problem31;

import java.util.Stack;

public class PopSequence {
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 1, 2};
        System.out.println(isPopSequence(push, pop));
    }

    private static boolean isPopSequence(int[] push, int[] pop) {
        if (push == null || pop == null) return false;
        if (push.length != pop.length) return false;
        int len = push.length;
        int pushIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i ++){
            if(!stack.empty()){
                if(stack.peek().equals(pop[i])){
                    stack.pop();
                }else{
                    while(pushIndex < len){
                        stack.add(push[pushIndex]);
                        if(push[pushIndex] == pop[i]){
                            break;
                        }
                        pushIndex++;
                    }
                    if(pushIndex >= len) {
                        return false;
                    }else{
                        stack.pop();
                        pushIndex ++;
                    }
                }
            }else {
                while(pushIndex < len){
                    stack.add(push[pushIndex]);
                    if(push[pushIndex] == pop[i]){
                        break;
                    }
                    pushIndex++;
                }
                if(pushIndex >= len) {
                    return false;
                }else{
                    stack.pop();
                    pushIndex ++;
                }
            }


        }
        return true;
    }
}
