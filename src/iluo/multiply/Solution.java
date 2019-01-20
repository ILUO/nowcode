package iluo.multiply;
import java.util.ArrayList;

public class Solution {
    public int[] multiply(int[] A) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        left.add(1);
        right.add(1);
        int length = A.length;
        for(int i = 1;i < length;i++){
            left.add(left.get(left.size()-1)*A[i]);
            right.add(right.get(right.size()-1)*A[length-i]);
        }
        int [] result = new int[length];
        left.remove(left.size()-1);
        right.remove(0);
        result[0] = right.get(right.size()-1);
        result[length-1] = left.get(left.size()-1);

        for(int i = 0;i < left.size()-1;i++){
            result[i+1] = left.get(i)*right.get(right.size()-i-2);
        }
        return result;
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a = {1,2,3,4,5};
        solution.multiply(a);
    }

}
