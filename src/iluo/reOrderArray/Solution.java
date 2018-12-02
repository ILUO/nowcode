package iluo.reOrderArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void reOrderArray(int [] array) {
        List<Integer> oddArray = new ArrayList<Integer>();
        List<Integer> evenArray = new ArrayList<Integer>();

        for(int i = 0;i < array.length;i++){
            if(array[i] % 2 != 0){
                oddArray.add(array[i]);
            }else{
                evenArray.add(array[i]);
            }
        }


        for(int i = 0;i < oddArray.size(); i++){
            array[i] = oddArray.get(i);
        }

        int length = oddArray.size();


        for(int j = length;j < evenArray.size() + length ;j++){
            array[j] = evenArray.get(j - length);
        }
    }

    public static void main(String [] args){
        Solution solution = new Solution();
        int [] array = {2,1};
        solution.reOrderArray(array);
        for(int i=0;i < array.length;i++){
            System.out.print(array[i]);
        }
    }

}