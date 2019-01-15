package iluo.LeftRotateString;

public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0){
            return str;
        }
        int length = str.length();
        int moveStep = n % length;
        if(moveStep > 0){
            str = str.substring(moveStep) + str.substring(0,moveStep);
        }
        return str;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String str = "abc";
        System.out.println(solution.LeftRotateString(str,6));
    }
}
