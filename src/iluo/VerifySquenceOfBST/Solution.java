package iluo.VerifySquenceOfBST;

import java.util.ArrayList;

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        boolean result = true;
        int length = sequence.length;
        if(length == 0){
            return false;
        }
        if(length > 2){
            ArrayList<Integer> sequenceList = new ArrayList<>();
            for(int i=0;i < length;i++){
                sequenceList.add(sequence[i]);
                result = check(sequenceList);
            }
        }
        return result;
    }

    private boolean check(ArrayList<Integer> sequence){
        if(sequence.size() < 3){
            return true;
        }

        int length = sequence.size();
        int lastNum = sequence.get(length - 1);
        int splitIndex = 0;
        for(int i = length - 2; i > 0;i--){
            if(sequence.get(i) < lastNum){
                splitIndex = i + 1;
                break;
            }
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i = 0;i < splitIndex - 1;i++){
            if(sequence.get(i) > sequence.get(length - 1)){
                return false;
            }
        }

        for(int i = 0;i < splitIndex;i++){
            left.add(sequence.get(i));
        }

        for(int i = splitIndex; i < length - 1;i++){
            right.add(sequence.get(i));
        }

        return check(left) && check(right);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] sequence = {2,1,5};
        System.out.println(solution.VerifySquenceOfBST(sequence));
    }
}
