package iluo.jumpfloortwo;

public class Solution {
    public int JumpFloorII(int target) {
        for(int i = 0;i <= target;i++){
            if(i == target){
                return 1;
            }
            else{
                int sum = 0;
                for(int j = 1; j <= target;j++){
                    sum = sum + JumpFloorII(target - j);
                }
                return sum;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        for(int i = 0;i <= 10;i++){
            System.out.println(solution.JumpFloorII(i));
        }
    }
}