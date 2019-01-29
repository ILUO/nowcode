package iluo.GetMedian;

import iluo.util.TreeNode;

public class Solution {
    TreeNode treeNode = null;
    int countInsert = 0;
    int [] resultIndex = new int[2];
    Double[] result = new Double[2];

    public void Insert(Integer num) {
        treeNode = insertCore(num,treeNode);
        countInsert++;
    }

    public Double GetMedian() {
        int [] countIn = {0};
        if(countInsert % 2 == 0){
            resultIndex[0] = countInsert/2;
            resultIndex[1] = countInsert/2+1;
        }else{
            resultIndex[0] = countInsert/2+1;
        }
        in(treeNode,result,countIn);
        if(countInsert % 2 ==0){
            return (result[0]+result[1]) / 2;
        }else {
            return result[0];
        }
    }

    private TreeNode insertCore(Integer num,TreeNode root){
        TreeNode newNode = new TreeNode(num);
        TreeNode lastNode = null;
        TreeNode tempRoot = root;
        while(tempRoot != null){
            if(tempRoot.val > num){
                lastNode = tempRoot;
                tempRoot = tempRoot.left;
            }else{
                lastNode = tempRoot;
                tempRoot = tempRoot.right;
            }
        }
        if(lastNode == null){
            return newNode;
        }else if(lastNode.val > newNode.val){
            lastNode.left = newNode;
        }else{
            lastNode.right = newNode;
        }
        return root;
    }

    private void in(TreeNode treeNode,Double[] result,int[] countIn){
        if(treeNode == null){
            return;
        }
        in(treeNode.left,result,countIn);
        countIn[0]++;
        if(countInsert % 2 == 0){
            if(countIn[0] == resultIndex[0]){
                result[0] = (double)treeNode.val;
            }else if(countIn[0] ==  resultIndex[1]){
                result[1] = (double)treeNode.val;
                return;
            }
        }else{
            if(countIn[0] == resultIndex[0]){
                result[0] = (double)treeNode.val;
            }
        }
        in(treeNode.right,result,countIn);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a = {5,2,3,4,1,6,7,0,8};
        for(int i = 0;i < a.length;i++){
            solution.Insert(a[i]);
            System.out.println(solution.GetMedian());
        }

    }
}
