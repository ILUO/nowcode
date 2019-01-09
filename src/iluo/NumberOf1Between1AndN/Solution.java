package iluo.NumberOf1Between1AndN;
public class Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;

        if(n < 1){
            return 0;
        }

        if(n <= 9){
            return 1;
        }

        int bit = 0;

        for(int i = n;i > 0;i = i/10){
            bit++;
        }

        int x = powerOften(bit);
        int i = n%x;

        //highestBit is 1
        if(n/powerOften(bit) == x/powerOften(bit)){
            count += i + 1;
        }else{
            count += x;
        }

        int part = (n - i) / x;
        count += part * (bit-1) * powerOften(bit - 1);

        return count+NumberOf1Between1AndN_Solution(i);
    }


    public static void main(String [] args){
        Solution solution = new Solution();
        int count = solution.NumberOf1Between1AndN_Solution(21345);
        System.out.println(count);
    }



    private int powerOften(int bit){
        int result = 1;
        for(int i = 1;i < bit;i++){
            result = result * 10;
        }
        return result;
    }

}
