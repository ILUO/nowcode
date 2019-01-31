package iluo.movingCount;

/**
 * Created by Yang Xing Luo on 2019/1/31.
 */
public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        int []result = {0};
        int [][] isUsed = new int[rows][cols];
        movingCountCore(result,isUsed,threshold,0,0,rows,cols);
        return result[0];
    }

    private void movingCountCore(int []result,int [][] isUsed,int threshold,int i,int j,int rows,int cols){
        if(i < 0 || j < 0 || i >= rows || j >= cols){
            return;
        }
        if(getSum(i)+getSum(j) <= threshold){
            if(isUsed[i][j] != 1){
                result[0]++;
                isUsed[i][j] = 1;
            }
        }else {
            return;
        }
        if(i+1 < rows && isUsed[i+1][j] != 1) {
            movingCountCore(result,isUsed,threshold,i+1,j,rows,cols);
        }
        if(j+1 < cols && isUsed[i][j+1] != 1){
            movingCountCore(result,isUsed,threshold,i,j+1,rows,cols);
        }
        if(i-1 > 0 && isUsed[i-1][j] != 1){
            movingCountCore(result,isUsed,threshold,i-1,j,rows,cols);
        }
        if(j-1 > 0 && isUsed[i][j-1] != 1){
            movingCountCore(result,isUsed,threshold,i,j-1,rows,cols);
        }
    }


    private int getSum(int num){
        if(num / 10 == 0){
            return num % 10;
        }
        return num/10 + getSum(num%10);
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.movingCount(4,5,6));
    }


}
