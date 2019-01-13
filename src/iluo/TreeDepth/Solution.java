package iluo.TreeDepth;
import iluo.util.TreeNode;
import iluo.util.ReConstructBinaryTree;

public class Solution {
    public int TreeDepth(TreeNode root) {
        return DFS(root);
    }

    private int DFS(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftLength = 1 + DFS(root.left);
        int rightLength = 1 + DFS(root.right);
        if(leftLength > rightLength){
            return leftLength;
        }else{
            return rightLength;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        int [] pre1 = {1,2,4,7,3,5,6,8,9};
        int [] in1 = {4,7,2,1,5,3,9,8,6};
        int [] pre2 = {1};
        int [] in2 = {1};
        TreeNode root = reConstructBinaryTree.reConstructBinaryTree(pre1,in1);
        TreeNode root2 = reConstructBinaryTree.reConstructBinaryTree(pre2,in2);
        System.out.println(solution.TreeDepth(root2));
    }

}
