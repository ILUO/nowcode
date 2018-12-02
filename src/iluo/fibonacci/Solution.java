package iluo.fibonacci;

public class Solution {
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return Fibonacci(n-2) + Fibonacci(n-1);
        }
    }

    public static void main(String []args){
        Solution solution = new Solution();
        for(int i=0; i <= 39;i++){
            System.out.println(solution.Fibonacci(i));
        }
    }

}