package iluo.IsBalanced;

import iluo.util.TreeNode;
import iluo.util.ReConstructBinaryTree;

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return checkBalanced(root);
    }

    private int DFS(TreeNode root){
        int leftLength = 0;
        int rightLength = 0;

        if(root == null){
            return 0;
        }

        leftLength = 1 + DFS(root.left);
        rightLength = 1 + DFS(root.right);

        if(leftLength > rightLength){
            return leftLength;
        }else{
            return rightLength;
        }
    }

    private boolean checkBalanced(TreeNode root){
        boolean flag = true;

        if(root == null){
            return true;
        }

        int leftLength = DFS(root.left);
        int rightLength = DFS(root.right);

        if(leftLength - rightLength > 1 || leftLength - rightLength < -1){
            flag = false;
        }
        return flag&&checkBalanced(root.left)&&checkBalanced(root.right);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        int [] pre1 = {1,2,4,7,3,5,6,8,9};
        int [] in1 = {4,7,2,1,5,3,9,8,6};
        int [] pre2 = {1};
        int [] in2 = {1};
        TreeNode root = reConstructBinaryTree.reConstructBinaryTree(pre1,in1);
        TreeNode root1 = reConstructBinaryTree.reConstructBinaryTree(pre2,in2);
        System.out.println(solution.IsBalanced_Solution(root1));
    }
}
