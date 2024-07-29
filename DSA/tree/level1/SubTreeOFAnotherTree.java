package DSA.tree.level1;

import DSA.tree.TreeNode;

public class SubTreeOFAnotherTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree(new Object[]{3,4,5,1,2,null,null,null,null,0});
        TreeNode subRoot = TreeNode.makeTree(new Object[]{4,1,2});
        if(isSubTree(root,subRoot)){
            System.out.println("Yes! this is Subtree");
        }else{
            System.out.println("No! this is not Subtree");
        }
    }

    private static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
}
