package iluo.stacktoqueue;

/**
 * Created by Yang Xing Luo on 2018/10/11.
 */
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        while(stack1.size()>1){
            stack2.push(stack1.pop());
        }

        int result = stack1.pop();

        while(stack2.size()>0){
            stack1.push(stack2.pop());
        }

        return result;

    }

    public static void main(String [] args){
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution.pop());
        solution.push(4);
        solution.push(5);
        solution.push(6);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}


