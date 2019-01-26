package iluo.KthNode;
import iluo.util.ReConstructBinaryTree;
import iluo.util.TreeNode;
import java.util.Stack;

public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode[] node = new TreeNode[1];
        int[] count = {0};
        Stack<TreeNode> stack = new Stack<>();
        in(pRoot, node, count, k, stack);
        return node[0];
    }

    private void in(TreeNode pRoot, TreeNode[] node, int[] count, int k, Stack<TreeNode> stack) {
        if (pRoot == null) return;
        stack.push(pRoot);
        in(pRoot.left, node, count, k, stack);
        TreeNode temp = stack.pop();
        count[0]++;
        if (count[0] == k) {
            node[0] = temp;
        }
        in(pRoot.right, node, count, k, stack);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        int[] pre = {5, 3, 2, 4, 7, 6, 8};
        int[] in = {2, 3, 4, 5, 6, 7, 8};
        TreeNode root = reConstructBinaryTree.reConstructBinaryTree(pre, in);
        System.out.println(solution.KthNode(root,8));
    }
}