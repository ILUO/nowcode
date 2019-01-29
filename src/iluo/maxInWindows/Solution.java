package iluo.maxInWindows;
import java.util.ArrayList;

/**
 * Created by Yang Xing Luo on 2019/1/28.
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> result = new ArrayList<>();
        if(size <= 0 || size > num.length){
            return result;
        }
        if(size >= num.length){
            result.add(getMax(num,0,num.length));
            return result;
        }
        int step = num.length - size + 1;
        int max = getMax(num,0,size);
        result.add(max);
        for(int i = 1;i < step;i++){
            if(max == num[i-1] || num[i+size-1] > max){
                max = getMax(num,i,i+size);
            }
            result.add(max);
        }
        return result;
    }

    private int getMax(int[] windows,int start,int end){
        int max = windows[start];
        for(int i = start;i < end;i++){
            if(max < windows[i]){
                max = windows[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {16,14,12,10,8,6,4};
        System.out.println(solution.maxInWindows(a,5));
    }
}
