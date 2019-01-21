package iluo.isNumeric;

public class Solution {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }
        int idxOfE = -1,startIdx = 0;
        if(str[startIdx] == '+' || str[startIdx] == '-') startIdx ++;
        for(int i = startIdx;i < str.length;i++){
            if((str[i] == 'e' || str[i] == 'E') && idxOfE == -1){
                idxOfE = i;
            }
        }
        if(idxOfE != -1){
            return isFloat(str,0,idxOfE) && isInteger(str,idxOfE+1,str.length);
        }else {
            return isFloat(str,0,str.length);
        }

    }

    private boolean isInteger(char[] str,int start,int end){
        if(start > str.length-1) return false;
        int startIdx = start;
        if(str[start] == '+' || str[start] == '-') startIdx ++;
        for(int i = startIdx;i < end;i++){
            if(!(str[i] >= '0' && str[i] <= '9')){
                return false;
            }
        }
        return true;
    }

    private boolean isFloat(char[] str,int start,int end){
        int startIdx = start;
        if(str[startIdx] == '+' || str[startIdx] == '-') startIdx ++;
        boolean pointFlag = false;
        for(int i = startIdx; i < end;i++){
            if(str[i] == '.' && !pointFlag){
                pointFlag = true;
                continue;
            }
            if(str[i] == '.' && pointFlag) return false;
            if(!(str[i] >= '0' && str[i] <= '9')) return false;
        }
        return true;
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        char [] a = {'3','1','.','e','1','0'};
        String b = "-.123";
        String c = "5e2";
        String d = "-123";
        String e = "3.1416";
        String f = "-1E-16";
        String g = "12e";
        String h = "1a3.14";
        String i = "+-5";
        System.out.println(solution.isNumeric(b.toCharArray()));
    }

}