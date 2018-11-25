package iluo.twodimensionsearch;

/**
 * Created by Yang Xing Luo on 2018/9/22.
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        boolean flag = false;
        int row = array.length- 1;
        int col = array[0].length - 1;
        if(row > 0 && col > 0){
            for(int i = 0; i <= row; i++){
                if(array[i][0] <= target || array[i][col] >= target){
                    flag = LocationY(target,array,0,col,i);
                    if(flag){
                        return flag;
                    }
                }
            }
        }
        return flag;
    }

    private boolean LocationY(int target,int [][] array,int start,int end,int x){
        int mid = (start + end) / 2;
        if(start >= end){
            if(array[x][start] == target){
                return true;
            }else{
                return false;
            }
        }else{
            if(target < array[x][mid]){
                end = mid - 1;
            }else if(target > array[x][mid]){
                start = mid + 1;
            }else if(target == array[x][mid]){
                return true;
            }
            return LocationY(target,array,start,end,x);
        }
    }

    public static void main(String [] args){
        int [][] array = {{}};
        int target = 7;
        Solution solution = new Solution();
        solution.Find(target,array);
    }
}
