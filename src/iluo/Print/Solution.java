package iluo.Print;
import iluo.util.ReConstructBinaryTree;
import iluo.util.TreeNode;
import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;
        ArrayList<ArrayList<TreeNode>> levelList = new ArrayList<>();
        ArrayList<TreeNode> nextLevel = new ArrayList<>();
        nextLevel.add(pRoot);
        levelList.add(nextLevel);

        int countLevel = 2;
        while(nextLevel.size() != 0){
            ArrayList<TreeNode> tempLevel = new ArrayList<>();
            if(countLevel % 2 != 0){
                for(int i = nextLevel.size()-1;i >= 0;i--){
                    TreeNode node = nextLevel.get(i);
                    if(node.left != null){
                        tempLevel.add(node.left);
                    }
                    if(node.right != null){
                        tempLevel.add(node.right);
                    }
                }
            }else {
                for(int i = nextLevel.size()-1;i >= 0;i--){
                    TreeNode node = nextLevel.get(i);
                    if(node.right != null){
                        tempLevel.add(node.right);
                    }
                    if(node.left != null){
                        tempLevel.add(node.left);
                    }
                }
            }
            if(tempLevel.size() != 0){
                levelList.add(tempLevel);
            }
            nextLevel = tempLevel;
            countLevel++;
        }
        for(int i = 0;i < levelList.size();i++){
            ArrayList<Integer> tempLevelVal = new ArrayList<>();
            ArrayList<TreeNode> tempLevelNode = levelList.get(i);
            for(int j = 0;j < tempLevelNode.size();j++){
                tempLevelVal.add(tempLevelNode.get(j).val);
            }
            result.add(tempLevelVal);
        }
        return result;
    }

    public static void main(String[] args){
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        int [] pre1 = {1,2,4,7,3,5,6,8};
        int [] in1 = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree.reConstructBinaryTree(pre1,in1);
        Solution solution = new Solution();
        solution.Print(root);
    }

}
