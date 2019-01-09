package iluo.FindGreatestSumOfSubArray;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int tempSum = array[0];

        for(int i = 1;i < array.length;i++){
            if(tempSum < 0){
                tempSum = array[i];
            }else{
                tempSum += array[i];
            }
            if(tempSum > max){
                max = tempSum;
            }
        }

        return max;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int []a = {6,-3,-2,7,-15,1,2,2};
        System.out.println(solution.FindGreatestSumOfSubArray(a));
    }


}
