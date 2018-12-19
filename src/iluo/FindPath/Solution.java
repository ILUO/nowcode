package iluo.FindPath;
import iluo.util.ReConstructBinaryTree;
import iluo.util.TreeNode;
import java.util.ArrayList;
import java.util.Stack;


public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        if(root != null){
            stack.push(root);
            DFS(stack,result,root,target);
        }
        return result;
    }

    private void DFS(Stack<TreeNode> stack,ArrayList<ArrayList<Integer>> result,TreeNode root,int target){
        if(root.left == null && root.right == null){
            int size = stack.size();
            int checkTarget = 0;
            for(int i = 0;i < size;i++){
                checkTarget += stack.get(i).val;
            }
            if(checkTarget == target){
                ArrayList<Integer> arrayList= new ArrayList<>();
                for(int i = 0;i < size;i++){
                    arrayList.add(stack.get(i).val);
                }
                result.add(arrayList);
            }
            return;
        }

        if(root.left != null){
            stack.push(root.left);
            DFS(stack,result,root.left,target);
            stack.pop();
        }

        if(root.right != null){
            stack.push(root.right);
            DFS(stack,result,root.right,target);
            stack.pop();
        }

    }

    public static void main(String[] args){
        int [] pre1 = {1,2,4,7,3,5,6,8};
        int [] in1 = {4,7,2,1,5,3,8,6};

        Solution solution = new Solution();
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        TreeNode treeNode = reConstructBinaryTree.reConstructBinaryTree(pre1,in1);
        System.out.println(solution.FindPath(treeNode,14));
    }


}
