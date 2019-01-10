package iluo.FirstNotRepeatingChar;
import java.util.HashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        char [] strChar = str.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0;i < strChar.length;i++){
            if(!hashMap.containsKey((strChar[i]))){
                hashMap.put(strChar[i],1);
            }else{
                hashMap.put(strChar[i],hashMap.get(strChar[i])+1);
            }
        }

        for(int i = 0;i < strChar.length;i++){
            if(hashMap.get(strChar[i]) == 1){
                return i;
            }
        }


        return -1;
    }

    public static void main(String []args){
        Solution solution = new Solution();
        System.out.println(solution.FirstNotRepeatingChar("ababcdcfggh"));
    }

}
