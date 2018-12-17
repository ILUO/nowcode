package iluo.util;

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length>0){
            TreeNode ancient = new TreeNode(pre[0]);
            reConstruc(pre,in,ancient);
            preCons(ancient);
            inCons(ancient);
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

    private void preCons(TreeNode treeNode){
        System.out.print(treeNode.val);
        if(treeNode.left!=null){
            preCons(treeNode.left);
        }
        if(treeNode.right!=null){
            preCons(treeNode.right);
        }
    }
    private void inCons(TreeNode treeNode){
        if(treeNode.left!=null){
            inCons(treeNode.left);
        }
        System.out.print(treeNode.val);
        if(treeNode.right!=null){
            inCons(treeNode.right);
        }
    }
}
