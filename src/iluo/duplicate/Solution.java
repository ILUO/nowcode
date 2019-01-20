package iluo.duplicate;

public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length < 2){
            return false;
        }
        int flag = 0;
        for(int i = 0; i < numbers.length;i++){
            if((flag >> numbers[i] & 1 )== 1){
                duplication[0] = numbers[i];
                return  true;
            }
            flag |= (1<<numbers[i]);
        }
        return false;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a = {1,2,2,4,5,6,7};
        int [] b = new int[1];
        System.out.println(solution.duplicate(a,a.length,b));
        System.out.println(b[0]);
    }
}
