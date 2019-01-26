package iluo.Serialize;


import iluo.util.ReConstructBinaryTree;
import iluo.util.TreeNode;

/**
 * Created by Yang Xing Luo on 2019/1/25.
 */
public class Solution {
    int index = -1;

    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        return String.valueOf(root.val) +","+Serialize(root.left) +","+Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        index++;
        String[] strs = str.split(",");
        TreeNode node = null;
        if(!strs[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
            return node;
        }
        return null;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        int [] pre1 = {1,2,4,7,3,5,6,8};
        int [] in1 = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree.reConstructBinaryTree(pre1,in1);
        solution.Deserialize(solution.Serialize(root));
    }
}
