package iluo.isContinuous;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5) return false;
        int [] count = new int[14];
        int min = 14;
        int max = -1;
        for(int i = 0;i < numbers.length;i++){
            if(numbers[i] == 0) continue;
            count[numbers[i]]++;
            if(count[numbers[i]] > 1) return false;
            if(numbers[i] < min){
                min = numbers[i];
            }
            if(numbers[i] > max){
                max = numbers[i];
            }
            if(max - min >= 5) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a = {0,0,3,4,5};
        System.out.println(solution.isContinuous(a));
    }
}
