package iluo.minStack;

import java.util.Stack;

public class Solution {

    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public void push(int node) {
        if(stack1.isEmpty()){
            stack1.push(node);
            stack2.push(node);
        }else{
            stack1.push(node);
            if(node > top()){
                stack2.push(top());
            }else{
                stack2.push(node);
            }
        }
    }

    public void pop() {
        int size = stack1.size();
        stack1.remove(size-1);
        stack2.remove(size-1);
    }

    public int top() {
        int size = stack2.size();
        return Integer.parseInt(stack2.get(size - 1).toString());
    }

    public int min() {
        return top();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] data = {5,2,6,3,4};
        for(int i = 0;i < data.length;i++){
            solution.push(data[i]);
        }

        System.out.println(solution.stack1);
        System.out.println(solution.stack2);
        System.out.println(solution.min());
    }


}
