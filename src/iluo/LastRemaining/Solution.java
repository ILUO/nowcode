package iluo.LastRemaining;

import java.util.ArrayList;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(m == 0 || n == 0){
            return -1;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i < n;i++){
            arrayList.add(i);
        }
        int idx = m % arrayList.size();
        return lastRemaining(arrayList,m,idx);
    }

    private int lastRemaining(ArrayList<Integer> arrayList,int m,int idx){
        if(arrayList.size() == 1){
            return arrayList.get(0);
        }

        if(idx != 0){
            if(idx == arrayList.size()){
                arrayList.remove(idx - 1);
                idx = 1;
            }else{
                arrayList.remove(idx - 1);
            }
        }else{
            arrayList.remove(0);
        }

        int size = arrayList.size();
        for(int i = idx,step = 1;step <= m;step++){
            if(step == m){
                idx = i;
            }
            if(i == size){
                i = 1;
            }else{
                i++;
            }
        }
        return lastRemaining(arrayList,m,idx);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.LastRemaining_Solution(5,3));
    }
}
