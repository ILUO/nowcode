package iluo.numberofone;

import java.util.ArrayList;

public class Solution {
    public int NumberOf1(int n) {
        ArrayList<Integer> binaryCodeList = new ArrayList<Integer>();
        boolean flag;
        int count = 0;


        if(n >= 0){
            flag = true;
            binaryCodeList = getBinaryCode(n, binaryCodeList,flag); 
            System.out.println(binaryCodeList);
        }else{
            flag = false;
            n = -n;
            binaryCodeList = getBinaryCode(n, binaryCodeList,flag);
            binaryCodeList = getComplement(binaryCodeList);
            System.out.println(binaryCodeList);
        }

        for(int i = 0;i < binaryCodeList.size();i++){
            if(binaryCodeList.get(i) == 1){
                count++;
            }
        }
        return count;
    }

    public ArrayList getBinaryCode(int n,ArrayList<Integer> binaryCodeList,boolean flag){
        if(n==0){
            if(flag){
                binaryCodeList.add(0, 0);
            }else{
                for(;binaryCodeList.size()<33;){
                    if(binaryCodeList.size()==32){
                        binaryCodeList.add(0, 1);
                    }else{
                        binaryCodeList.add(0, 0);
                    }
                }
            }
            return binaryCodeList;
        } 
        Integer code = n%2;
        binaryCodeList.add(0, code);
        n = n/2;
        return getBinaryCode(n, binaryCodeList,flag);
    }

    public ArrayList getComplement(ArrayList<Integer> binaArrayList){
        int flag = 0;
        for(int i=binaArrayList.size();i > 1;i--){
            if(binaArrayList.get(i-1) == 1){
                flag = 1;
            }
            if(flag == 1){
                if(binaArrayList.get(i-1) == 0){
                    binaArrayList.set(i-1, 1);
                }else if(binaArrayList.get(i-1) == 1){
                    binaArrayList.set(i-1, 0);
                }
            }
        }
        return binaArrayList;
    }



    public static void main(String[] args){
        Solution solution = new Solution();
        for(int i = -10;i < 10;i++){
            System.out.println(solution.NumberOf1(i));
        }
    }
}