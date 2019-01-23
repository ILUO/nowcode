package iluo.FirstAppearingOnce;

public class Solution {
    private int [] chCount = new int[128];
    private StringBuffer s = new StringBuffer();

    //Insert one char from stringstream
    public void Insert(char ch) {
        s.append(ch);
        chCount[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char [] a = s.toString().toCharArray();
        for(char c:a){
            if(chCount[c] == 1){
                return c;
            }
        }
        return '#';
    }
}
