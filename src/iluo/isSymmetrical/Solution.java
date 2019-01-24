package iluo.isSymmetrical;

import iluo.util.ReConstructBinaryTree;
import iluo.util.TreeNode;

public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) return false;
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        return core(left,right);
    }

    private boolean core(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if((left == null) || (right == null)) return false;
        if(left.val != right.val) return false;
        return core(left.left,right.right) && core(left.right,right.left);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        int [] pre1 = {1,2,3,4,2,4};
        int [] in1 = {3,2,4,1,4,2};
        TreeNode root = reConstructBinaryTree.reConstructBinaryTree(pre1,in1);
        System.out.println(solution.isSymmetrical(root));
    }
}

