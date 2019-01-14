package iluo.FindNumsAppearOnce;

public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2){
            return;
        }
        int temp = 0;
        for(int i = 0;i < array.length;i++){
            temp ^= array[i];
        }
        int idx = findFirstBit(temp);

        for(int i = 0;i < array.length;i++){
            if(isBit(array[i],idx)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }

    }

    private int findFirstBit(int num){
        int idx = 0;
        while(((num & 1) == 0) && (idx  < 32)){
            num = num >> 1;
            ++idx;
        }
        return idx;
    }


    private boolean isBit(int num,int idx){
        num = num >> idx;
        return (num & 1) == 1;
    }

    public static void main(String[] args){
        int []num1 = new int[1];
        int []num2 = new int[1];
        int []array = {1,2,3,3,4,4,4,4,5,5,6,6,6,6};
        Solution solution = new Solution();
        solution.FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }

}
