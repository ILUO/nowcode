package iluo.minnumberinrotatearray;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        return findMin(array, 0,array.length-1, array[array.length-1]);
    }

    public int findMin(int [] array,int start,int end,int target){
        if(start>=end){
            return array[start];
        }
        int mid = (start + end) / 2;
        if(array[mid] > target){
            return findMin(array, mid + 1, end, target);
        }else{
            if(mid >= 1){
                if(array[mid]<array[mid-1]){
                    return array[mid];
                }
            }
            return findMin(array, start, mid - 1, target);
        }
    }

    public static void main(String []args){
        int [] array = {3,3,3,3,4,4,4,4,4,5,5,5,5,5,5,1,1,1,1,2,2,2,2};
        Solution solution = new Solution();
        System.out.println(solution.minNumberInRotateArray(array));
    }

}

