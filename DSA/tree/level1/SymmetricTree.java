package DSA.tree.level1;

import DSA.tree.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree(new Object[]{2,3,3,4,5,5});

        if(root==null || getSymmetricTree(root.left,root.right)){
            System.out.println("Yes! This is the Symmetric Tree");
        }else{
            System.out.println("Yes! This is the not Symmetric Tree");
        }
    }

    private static boolean getSymmetricTree(TreeNode left, TreeNode right) {
        if(left==null && right!=null) return false;
        if(right==null && left!=null) return false;
        if(left==null && right==null) return true;
        if(left.val!=right.val) return  false;
        return getSymmetricTree(left.left,right.right) && getSymmetricTree(left.right,right.left);
    }
}
