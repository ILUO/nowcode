package iluo.Print2;

import iluo.util.TreeNode;
import java.util.ArrayList;

public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<TreeNode>> levelList = new ArrayList<>();
        if(pRoot == null){
            return result;
        }
        ArrayList<TreeNode> nextLevel = new ArrayList<>();
        nextLevel.add(pRoot);
        levelList.add(nextLevel);

        while(nextLevel.size() != 0){
            ArrayList<TreeNode> tempLevel = new ArrayList<>();
            for(int i = 0;i < nextLevel.size();i++){
                TreeNode tempNode = nextLevel.get(i);
                if(tempNode.left != null){
                    tempLevel.add(tempNode.left);
                }
                if(tempNode.right != null){
                    tempLevel.add(tempNode.right);
                }
            }
            if(tempLevel.size() !=0){
                levelList.add(tempLevel);
            }
            nextLevel = tempLevel;
        }


        for(int i = 0;i < levelList.size();i++){
            ArrayList<TreeNode> tempLevel = levelList.get(i);
            ArrayList<Integer> tempLevelNumber = new ArrayList<>();
            for(int j = 0;j < tempLevel.size();j++){
                TreeNode tempNode = tempLevel.get(j);
                tempLevelNumber.add(tempNode.val);
            }
            result.add(tempLevelNumber);
        }
        return result;
    }
}
