package iluo.IsPopOrder;
import java.util.ArrayList;


public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        ArrayList<Integer> pusha = new ArrayList<>();
        ArrayList<Integer> popa = new ArrayList<>();
        for(int i = 0;i < pushA.length;i++){
            pusha.add(pushA[i]);
            popa.add(popA[i]);
        }
        boolean result = true;
        while(popa.size() != 0 && pusha.size()!=0) {
            result = checkOrder(pusha,popa);
            if(result){
                pusha.remove(popa.get(0));
                popa.remove(0);
                checkOrder(pusha,popa);
            }else{
                return result;
            }
        }
        return  result;

    }

    private boolean checkOrder(ArrayList<Integer> pusha,ArrayList<Integer> popa){
        if(pusha.size() == 0 && popa.size() == 0){
            return true;
        }
        int num = popa.get(0);

        int indexOfPush = -1;
        for(int i = 0;i < pusha.size();i++){
            if(num == pusha.get(i)){
                indexOfPush = i;
                break;
            }
        }
        if(indexOfPush == -1){
            return false;
        }


        for(int i = 0; i < indexOfPush - 1;i++){
            for(int j = i+1; j < indexOfPush - 1; j++){
                if(popa.indexOf(pusha.get(i)) < popa.indexOf(pusha.get(j))){
                    return  false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution =  new Solution();
        int[] pushA = {1,2,3,4,5,6};
        int[] popA = {2,1,4,3,5,6};
        System.out.println(solution.IsPopOrder(pushA,popA));
    }



}
