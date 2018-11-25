package iluo.replacespace;

/**
 * Created by Yang Xing Luo on 2018/9/23.
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if(str.length()==0){
            return str.toString();
        }
        String result = "";
        String re =  str.toString();
        String []  strList = re.split(" ");
        for(int i = 0;i <= strList.length - 1; i++){
            if(i == strList.length -1){
                result = result + strList[i];
            }else {
                result = result + strList[i] + "%20";
            }
        }
        if(str.charAt(str.length()-1) == " ".charAt(0)){
            for(int i = str.length()-1;i >=0 ;i--){
                if(str.charAt(i) == " ".charAt(0)){
                    result = result + "%20";
                }else{
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String []args){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("   we are happy  hh hh ");
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace(stringBuffer));
    }

}
