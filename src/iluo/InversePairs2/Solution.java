package iluo.InversePairs2;

public class Solution {
    private static int[] aux;

    public int InversePairs(int [] array) {
        return sort(array);
    }

    private int merge(int []a,int lo, int mid,int hi){
        int tempResult = 0;
        int i = lo,j = mid + 1;
        for(int k = lo;k<= hi;k++){
            aux[k] = a[k];
        }

        for(int k = lo; k <= hi;k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(aux[j] <= aux[i]){
                a[k] = aux[j++];
                tempResult += mid + 1 - i;
                tempResult = tempResult%1000000007;
            }
            else a[k] = aux[i++];
        }

        return tempResult%1000000007;


    }

    private int sort(int []a){
        aux = new int[a.length];
        return sort(a,0,a.length-1);
    }

    private int sort(int []a,int lo,int hi){
        if(hi <= lo) return 0;
        int mid = lo + (hi - lo)/2;
        int left = sort(a,lo,mid)%1000000007;
        int right = sort(a,mid+1,hi)%1000000007;
        int mergeCount = merge(a,lo,mid,hi);
        return (left+right+mergeCount)%1000000007;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a = {1,2,3,4,5,6,0};
//        solution.sort(a);
        System.out.println(solution.InversePairs(a));
        System.out.println(a[0]);
    }
}
