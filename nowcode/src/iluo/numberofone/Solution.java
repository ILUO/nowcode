package iluo.numberofone;

import java.util.ArrayList;

public class Solution {
    public int NumberOf1(int n) {
        if(n >= 0){
            ArrayList<Integer> binaryCodeList = new ArrayList<Integer>();
            binaryCodeList.add(0, 0);
            binaryCodeList = getBinaryCode(n, binaryCodeList); 
            System.out.print(binaryCodeList);
        }
        return 0;
    }

    public ArrayList getBinaryCode(int n,ArrayList binaryCodeList){
        if(n==0){
            return binaryCodeList;
        } 
        int code = n%2;
        binaryCodeList.add(0, code);
        n = n/2;
        return getBinaryCode(n, binaryCodeList);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        for(int i = 0;i < 10;i++){
            solution.NumberOf1(i);
        }
    }
}