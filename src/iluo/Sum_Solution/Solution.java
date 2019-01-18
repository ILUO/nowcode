package iluo.Sum_Solution;

public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n > 0)&&((sum +=Sum_Solution(n-1)) > 0);
        return sum;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.Sum_Solution(10));
    }
}
