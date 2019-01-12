package iluo.GetNumberOfK;

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int position = binarySearch(array,k,0, array.length-1);
        int result = 0;
        if(position != -1){
            for(int i=position;i < array.length;i++){
                if(array[i] == k) result++;
                else break;
            }
            for(int i = position - 1;i >= 0;i--){
                if(array[i] == k) result++;
                else break;
            }
        }

        return result;
    }

    private int binarySearch(int [] array, int k,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] < k){
            return binarySearch(array,k,mid+1,end);
        }else if(array[mid] > k){
            return binarySearch(array,k,start,end - 1);
        }else{
            return mid;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int []a = {1,2,3,4,4,5,5,5,5,5,6,7,8,9};
        int []b = {};
        System.out.println(solution.GetNumberOfK(b,-1));
    }


}
