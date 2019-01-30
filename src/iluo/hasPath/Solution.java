package iluo.hasPath;

/**
 * Created by Yang Xing Luo on 2019/1/30.
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(str == null || str.length == 0 || matrix == null || matrix.length == 0){
            return false;
        }
        char[][] matr = new char[rows][cols];
        boolean flag = false;
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                matr[i][j] = matrix[i*cols+j];
            }
        }
        int [][] isUsed = new int[rows][cols];
        for(int i = 0; i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(matr[i][j] == str[0]){
                    flag = hasPathCore(matr,str,i,j,isUsed,0,rows,cols,flag);
                    if(flag) return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[][] matr,char[] str,int i,int j,int [][] isUsed,int indexOfStr,int rows,int cols,boolean flag){
        if(i < 0 || j < 0 || i == rows || j == cols){
            return false;
        }
        if(str[indexOfStr] == matr[i][j]){
            isUsed[i][j] = 1;
            indexOfStr++;
            if(indexOfStr == str.length){
                return true;
            }
            if(i+1 < rows && isUsed[i+1][j] != 1){
                flag =  hasPathCore(matr,str,i+1,j,isUsed,indexOfStr,rows,cols,flag);
                if(!flag){
                    isUsed[i+1][j] = 0;
                }
            }
            if(j+1 < cols && isUsed[i][j+1] != 1){
                flag = flag || hasPathCore(matr,str,i,j+1,isUsed,indexOfStr,rows,cols,flag);
                if(!flag ){
                    isUsed[i][j+1] = 0;
                }
            }
            if(i-1 >= 0 && isUsed[i-1][j] != 1){
                flag = flag || hasPathCore(matr,str,i-1,j,isUsed,indexOfStr,rows,cols,flag);
                if(!flag){
                    isUsed[i-1][j] = 0;
                }
            }
            if(j-1 >= 0 && isUsed[i][j-1] != 1 ){
                flag = flag || hasPathCore(matr,str,i,j-1,isUsed,indexOfStr,rows,cols,flag);
                if(!flag){
                    isUsed[i][j-1] = 0;
                }
            }
            if(!flag){
                isUsed[i][j] = 0;
            }
            return flag;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        char [] matrix = {'a','b','c', 'e','h','j','i','g','s','f','c','s','l','o','p','q','a','d','e','e','m','n','o','e','a','d','i','d','e','j','f','m','v','c','e','i','f','g','g','s'};
        char [] str = {'s','g','g','f','i','e','c','v','a','a','s','a','b','c','e','h','j','i','g','q','e','m'};
        System.out.println(solution.hasPath(matrix,5,8,str));
    }

}
