package iluo.PrintFromTopToBottom;

import java.util.ArrayList;

import iluo.util.ReConstructBinaryTree;
import iluo.util.TreeNode;

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> treeNodeArrayList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(root != null){
            treeNodeArrayList.add(root);
        }
        while(treeNodeArrayList.size() != 0){
            getOneLayer(treeNodeArrayList,result);
        }
        return  result;
    }

    private void getOneLayer(ArrayList<TreeNode> treeNodeArrayList,ArrayList<Integer> result){
        ArrayList<TreeNode> layerNode = new ArrayList<>();
        for(int i = 0;i < treeNodeArrayList.size();i++){
            result.add(treeNodeArrayList.get(i).val);
            if(treeNodeArrayList.get(i).left != null){
                layerNode.add(treeNodeArrayList.get(i).left);
            }
            if(treeNodeArrayList.get(i).right != null){
                layerNode.add(treeNodeArrayList.get(i).right);
            }
        }
        treeNodeArrayList.clear();
        treeNodeArrayList.addAll(layerNode);
    }

    public static void main(String[] args){
        int [] pre1 = {1,2,4,7,3,5,6,8};
        int [] in1 = {4,7,2,1,5,3,8,6};

        Solution solution = new Solution();
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        TreeNode treeNode = reConstructBinaryTree.reConstructBinaryTree(pre1,in1);
        System.out.println(solution.PrintFromTopToBottom(null));

    }
}
