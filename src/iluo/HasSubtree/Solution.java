package iluo.HasSubtree;



public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;
        if(root2 == null || root1 == null){
            return false;
        }else{
            if(root1.val == root2.val){
                flag = doseHave(root1,root2);
            }
            if(!flag){
                flag = HasSubtree(root1.left,root2);
            }
            if(!flag){
                flag = HasSubtree(root1.right,root2);
            }
            return  flag;
        }
    }


    private boolean doseHave(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return  true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return doseHave(root1.left,root2.left) && doseHave(root1.right,root2.right);
    }




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


    public static void main(String [] args){
        int [] pre1 = {1,2,4,7,3,5,6,8};
        int [] in1 = {4,7,2,1,5,3,8,6};
        int [] pre2 = {3,5,6,8};
        int [] in2 = {5,3,8,6};

        Solution solution = new Solution();
        TreeNode root1 = solution.reConstructBinaryTree(pre1,in1);
        TreeNode root2 = solution.reConstructBinaryTree(pre2,in2);

        System.out.println(solution.HasSubtree(root1,root2));
    }

}