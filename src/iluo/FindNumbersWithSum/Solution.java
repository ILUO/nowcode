package iluo.FindNumbersWithSum;

/**
 * Created by Yang Xing Luo on 2019/1/14.
 */
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i < array.length - 1;i++){
            if(array[i] + array[i+1] > sum){
                return result;
            }else{
                int anotherNum = sum - array[i];
                int position = -1;
                if(anotherNum > array[i]){
                    position = binarySearch(array,i+1,array.length - 1,anotherNum);
                }
                if(anotherNum == array[i]){
                    position = binarySearch(array,i+1,array.length - 1,anotherNum);
                    if(position == -1){
                        position = binarySearch(array,0,i - 1,anotherNum);
                    }
                }
                if(position != -1){
                    if(result.size() == 2){
                        int product1 = result.get(0)*result.get(1);
                        int product2 = array[i]*array[position];
                        if(product2 < product2){
                            result.set(0,array[i]);
                            result.set(1,array[position]);
                        }
                    }else{
                        result.add(array[i]);
                        result.add(array[position]);
                    }
                }

            }
        }
        return result;
    }

    private int binarySearch(int [] array,int low,int high,int target){
        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;

        if(array[mid] < target){
            return binarySearch(array,mid+1,high,target);
        }else if(array[mid] > target){
            return binarySearch(array,low,mid-1,target);
        }else{
            return mid;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a = {-2,-1,2,3,4,5,7,8,9,10};
        System.out.println(solution.FindNumbersWithSum(a,1));
    }

}
