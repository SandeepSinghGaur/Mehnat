package DSA.tree.level1;

import DSA.tree.TreeNode;

public class IdenticalTree {
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.makeTree(new Object[]{1,2,3,4,null,null,null});
        TreeNode root2 = TreeNode.makeTree(new Object[]{1,2,3,4,null,null});
        Boolean ans = getIdenticalTree(root1,root2);
        if(ans){
            System.out.println("Both trees are identical");
        }else{
            System.out.println("Both trees are not identical");
        }

    }

    private static Boolean getIdenticalTree(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root2==null && root1!=null) return false;
        if(root1.val!=root2.val) return false;
        boolean left = getIdenticalTree(root1.left,root2.left);
        boolean right = getIdenticalTree(root1.right,root2.right);
        return (left && right);
    }
}
