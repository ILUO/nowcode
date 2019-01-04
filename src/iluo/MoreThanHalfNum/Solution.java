package iluo.MoreThanHalfNum;
import java.util.HashMap;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int length = array.length;
        int half = length / 2 + 1;


        int max = 0;

        for(int i = 0;i < length;i++){
            if(!hashMap.containsKey(array[i])){
                hashMap.put(array[i],1);
            }else{
                hashMap.get(array[i]);
                hashMap.put(array[i],hashMap.get(array[i]) + 1);
            }

            if(max < hashMap.get(array[i])){
                max = hashMap.get(array[i]);
            }

            if(max >= half){
                return array[i];
            }

            int leftToHalf = half - max;
            int left = length - i - 1;

            if(leftToHalf > left){
                return 0;
            }
        }
        return 0;
    }

    public static void main(String [] args){
        Solution solution = new Solution();
        int [] array = {1,2,3,3,3};
        System.out.print(solution.MoreThanHalfNum_Solution(array));
    }
}
