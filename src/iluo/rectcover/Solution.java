package iluo.rectcover;

public class Solution {
    public int RectCover(int target) {
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else if(target == 0){
            return 0;
        }
        else{
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
    public static void main(String []args){
        Solution solution = new Solution();
        for(int i = 0;i <= 10;i++){
            System.out.println(solution.RectCover(i));
        }
    }

}