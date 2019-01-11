package iluo.InversePairs;
import java.util.Arrays;

public class Solution {
    public int InversePairs(int []array){
        return InversePairs2(array)%1000000007;
    }

    private int InversePairs2(int [] array) {
        if(array.length <= 1){
            return 0;
        }
        int []part1 = Arrays.copyOfRange(array,0,array.length/2);
        int []part2 = Arrays.copyOfRange(array,array.length/2,array.length);
        return merge(part1,part2) + InversePairs2(part1) + InversePairs2(part2);
    }


    private int merge(int [] part1,int [] part2){
        int [] part1Clone = part1.clone();
        int [] part2Clone = part2.clone();
        sort(part1Clone,0,part1Clone.length - 1);
        sort(part2Clone,0,part2Clone.length - 1);
        int tempResult = 0;
        int j = 0;

        while(true){
            if( j >= part2Clone.length){
                break;
            }
            for(int i = 0;i < part1Clone.length;i++){
                if(part1Clone[i] > part2Clone[j]){
                    tempResult += part1Clone.length - i;
                    break;
                }
            }
            j++;
        }

        return tempResult;
    }


    private void sort(int [] array,int low,int high){
        if(low  >= high){
            return;
        }
        int i = low;
        int j = high + 1;
        int comparable = array[low];
        while(true){
            while(array[++i] <= comparable) if(i == high) break;
            while(array[--j] >= comparable) if(j == low) break;
            if(i >= j){
                break;
            }
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
        int temp = array[j];
        array[j] = array[low];
        array[low] = temp;
        sort(array,low,j - 1);
        sort(array,j + 1,high);
    }

    public static  void main(String[] args){
        Solution solution = new Solution();
        int [] sortArray = {4,0,1,2};
        solution.sort(sortArray,0,sortArray.length-1);
        System.out.println(sortArray[0]);
        int []array = {1,2,3,4,5,6,0};
        System.out.println(solution.InversePairs(array));
    }
}
