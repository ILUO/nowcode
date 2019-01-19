package iluo.StrToInt;

public class Solution {
    public int StrToInt(String str) {
        int result = 0;
        if(str == null || str.length()==0){
            return 0;
        }
        int length = str.length();
        Character firstChar = str.charAt(0);
        if(firstChar == '+' || firstChar == '-'){
            length = length-1;
            str = str.substring(1);
        }

        if(length > 10){
            return 0;
        }else if(length == 10){
            if(firstChar == '-'){
                if(str.compareTo("2147483648") > 0){
                    return 0;
                }
            }else if(str.compareTo("2147483647") > 0){
                return 0;
            }
        }

        for(int i = 0;i < length;i++){
            Character c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                if(c == '1'){
                    result += getPowerOfTen(length-i-1);
                }else if(c == '2'){
                    result += 2*getPowerOfTen(length-i-1);
                }else if(c == '3'){
                    result += 3*getPowerOfTen(length-i-1);
                }else if(c == '4'){
                    result += 4*getPowerOfTen(length-i-1);
                }else if(c == '5'){
                    result += 5*getPowerOfTen(length-i-1);
                }else if(c == '6'){
                    result += 6*getPowerOfTen(length-i-1);
                }else if(c == '7'){
                    result += 7*getPowerOfTen(length-i-1);
                }else if(c == '8'){
                    result += 8*getPowerOfTen(length-i-1);
                }else if(c == '9'){
                    result += 9*getPowerOfTen(length-i-1);
                }
            }else{
                return 0;
            }
        }
        if(firstChar == '-'){
            return -result;
        }
        return result;
    }


    private int getPowerOfTen(int n){
        int result = 1;
        while(n != 0){
            result = result*10;
            n--;
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.StrToInt("-9a23372"));
    }
}
