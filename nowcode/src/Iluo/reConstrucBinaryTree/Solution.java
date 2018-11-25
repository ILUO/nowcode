package iluo.reconstrucbinarytree;

/**
 * Created by Yang Xing Luo on 2018/10/10.
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length>0){
            TreeNode ancient = new TreeNode(pre[0]);
            reConstruc(pre,in,ancient);
            pre(ancient);
            in(ancient);
            return ancient;
        }else{
            return null;
        }
    }

    private int locationInIn(int [] in,int target){
        for(int i=0;i<in.length;i++){
            if(in[i] == target){
                return i;
            }
        }
        return -1;
    }

    private TreeNode reConstruc(int [] pre,int [] in,TreeNode treeNode){
        if(pre.length==1){
            return treeNode;
        }

        int firstPre = pre[0];
        int firstPreLocation = locationInIn(in,firstPre);

        if(firstPreLocation > 0){
            TreeNode left = new TreeNode(pre[1]);
            treeNode.left = left;
            int [] newPre = new int[firstPreLocation];
            int [] newIn = new int[firstPreLocation];
            System.arraycopy(pre,1,newPre,0,firstPreLocation);
            System.arraycopy(in,0,newIn,0,firstPreLocation);
            reConstruc(newPre,newIn,left);
        }

        if(firstPreLocation < in.length  - 1){
            TreeNode right = new TreeNode(pre[firstPreLocation+1]);
            treeNode.right = right;
            int [] newPre = new int[pre.length-1-firstPreLocation];
            int [] newIn = new int[pre.length -1-firstPreLocation];
            System.arraycopy(pre,firstPreLocation+1,newPre,0,pre.length-1-firstPreLocation);
            System.arraycopy(in,firstPreLocation+1,newIn,0,pre.length-1-firstPreLocation);
            return reConstruc(newPre,newIn,right);
        }

        return null;
    }

    private void pre(TreeNode treeNode){
        System.out.print(treeNode.val);
        if(treeNode.left!=null){
            pre(treeNode.left);
        }
        if(treeNode.right!=null){
            pre(treeNode.right);
        }
    }
    private void in(TreeNode treeNode){
        if(treeNode.left!=null){
            in(treeNode.left);
        }
        System.out.print(treeNode.val);
        if(treeNode.right!=null){
            in(treeNode.right);
        }
    }

    public static void main(String [] args){
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        Solution solution = new Solution();
        solution.reConstructBinaryTree(pre,in);
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
