package iluo.printMatrix;

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int w = matrix[0].length; //width
        int h = matrix.length; //height

        int i = 0;
        int j = 0;

        for(;i <= (h-1)/2 && j <= (w-1)/2;i++,j++){
            if(j >= w - j ){
                return  list;
            }

            for(int x = i,y = j; y < w - j;y++){
                list.add(matrix[x][y]);
            }

            if(i + 1 >= h - i){
                return  list;
            }
            for(int x = i + 1,y = w - j -1;x < h - i;x++){

                list.add(matrix[x][y]);
            }

            if(w - j -2 < j){
                return  list;
            }
            for(int x = h- i -1,y = w - j - 1 - 1;y >= j;y--){
                list.add(matrix[x][y]);
            }

            if(h - i <= i){
                return list;
            }
            for(int y = j,x = h - i - 1 - 1;x > i; x--){
                list.add(matrix[x][y]);
            }
        }
        return  list;


    }

    public static  void main(String []args){
        Solution solution = new Solution();
        int [][] matrix = {{1,2},{2,3},{3,4},{4,5},{5,6}};
        int [][] matrix1 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        int [][] matrix2 = {{1},{2},{3},{4},{5}};
        int [][] matrix3 = {{1,2,3,4,5}};
        int [][] matrix4 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int [][] matrix5 = {{1,2,3,4,5},{6,7,8,9,10}};
        System.out.println(solution.printMatrix(matrix1));

    }


}