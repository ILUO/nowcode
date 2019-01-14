package iluo.FindContinuousSequence;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(sum <= 0){
            return result;
        }

        for(int i = 2;sum / i >= 1; i ++){
            if(sum % i == 0 && i % 2 != 0){
                ArrayList<Integer> arrayList = getContinuosSequence(sum,i);
                if(arrayList != null){
                    result.add(0,arrayList);
                }
            }
            if(sum % i != 0){
                float divided = (float) sum/i;
                if(divided - sum/i == 0.5){
                    ArrayList<Integer> arrayList = getContinuosSequence(sum,i);
                    if(arrayList != null){
                        result.add(0,arrayList);
                    }
                }
            }
        }
        return result;
    }

    private ArrayList<Integer> getContinuosSequence(int sum,int i){
        ArrayList<Integer> result = new ArrayList<>();
        int mid = sum / i;
        int start;
        if(sum % i == 0){
            start = mid - i/2;
        }else {
            start = mid - i/2 + 1;
        }
        if(start <= 0){
            return null;
        }
        for(int j = 0;j < i;j++){
            result.add(start+j);
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.FindContinuousSequence(1));
    }
}
