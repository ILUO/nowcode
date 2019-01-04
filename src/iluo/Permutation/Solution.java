package iluo.Permutation;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        int length = str.length();
        fullPermutation(str,result,0,length-1);
        return result;
    }

    private void fullPermutation(String str,ArrayList<String> result,int start,int end){
        if(start == end){
                result.add(str);
        }else{
            for(int i = start;i <= end;i++){
                if(isSwap(str,start,i)){
                    str = swap(str,start,i);
                    fullPermutation(str,result,start+1,end);
                    str = swap(str,start,i);
                }
            }
        }
    }


    private String swap(String str,int i,int j){
        char [] chars = str.toCharArray();
        char temp = str.charAt(j);
        chars[j] = str.charAt(i);
        chars[i] = temp;
        return String.valueOf(chars);
    }

    private boolean isSwap(String str,int start,int end){

        for(int i = start;i < end;i++){
            if(str.charAt(start) == str.charAt(end)){
                return false;
            }
        }
        return true;
    }

    public static void main(String []args){
        String a = "abb";
        Solution solution = new Solution();
        System.out.print(solution.Permutation(a));
    }
}
