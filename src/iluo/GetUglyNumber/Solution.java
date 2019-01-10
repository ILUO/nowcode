package iluo.GetUglyNumber;

import java.util.ArrayList;

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index < 1){
            return 0;
        }
        ArrayList<Integer> uglyArraylist = new ArrayList<>();
        int [] basicUgly = {2,3,5};
        uglyArraylist.add(1);
        while(uglyArraylist.size() < index){
            int size = uglyArraylist.size();
            int maxUgly = uglyArraylist.get(size - 1);
            int tempMinUgly = -1;
            for(int i=0;i < size;i++){
                for(int j = 0;j < basicUgly.length;j++){
                    int tempUgly = uglyArraylist.get(i) * basicUgly[j];
                    if(tempUgly > maxUgly && tempMinUgly < 0){
                        tempMinUgly = tempUgly;
                    }else if(tempUgly > maxUgly && tempUgly < tempMinUgly){
                        tempMinUgly = tempUgly;
                    }
                }
            }
            uglyArraylist.add(tempMinUgly);
        }
        return uglyArraylist.get(uglyArraylist.size()-1);
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.GetUglyNumber_Solution(20));
    }
}
