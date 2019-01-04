package iluo.GetLeastNumbers;
import java.util.ArrayList;

public class Solution {
    private Integer [] pq;
    private int N = 0;

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        pq = new Integer[input.length+2];


        ArrayList<Integer> result = new ArrayList<>();
        if(input.length < k){
            return result;
        }

        for(int i=0;i < input.length;i++){
            insert(input[i]);
        }
        for(int i=0;i < k;i++){
            result.add(delMin());
        }

        return result;
    }

    private boolean less(int i,int j){
        if(pq[i] != null && pq[j]!= null){
            return pq[i] < pq[j];
        }else {
            return false;
        }

    }

    private void exch(int i,int j){
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        while(k > 1 && less(k,k/2)){
            exch(k,k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && !less(j,j+1)) j++;
            if(less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

    private void insert(int v){
        pq[++N] = v;
        swim(N);
    }

    private int delMin(){
        int min = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return min;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int []input = {4,5,1,6,2,7,3,8};
        System.out.print(solution.GetLeastNumbers_Solution(input,10));
    }

}
