package iluo.ReverseSentence;

import javax.jws.soap.SOAPBinding;

public class Solution {
    public String ReverseSentence(String str) {
        str = reverse(str,0,str.length()-1);
        int length = str.length();
        int start = 0,end = 0;
        for(;end < length;){
            while(start < length && str.charAt(start) == ' ' ){
                start++;
            }
            while(end < length && str.charAt(end) != ' ' ){
                end++;
            }
            if(start < end){
                str = reverse(str,start,end-1);
                start = end;
                end = end + 1;
            }
            if(start > end){
                end++;
            }
        }
        return str;
    }


    private String reverse(String str,int start,int end){
        while(start < end){
            str = str.substring(0,start) + str.substring(end,end+1) + str.substring(start+1,end) + str.substring(start,start+1) + str.substring(end+1);
            start++;
            end--;
        }
        return str;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String test = "i  I    am   a   student  ";
        System.out.println(solution.ReverseSentence(test));


    }
}
