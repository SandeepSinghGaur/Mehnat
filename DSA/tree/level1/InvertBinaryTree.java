package DSA.tree.level1;

import DSA.tree.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree(new Object[]{4,2,7,1,3,6,9});
        invertTree(root);
        TreeNode.printLevelOrder(root);
    }

    private static void invertTree(TreeNode root) {
        if(root==null) return;
        swapNode(root,root.left, root.right);
        invertTree(root.left);
        invertTree(root.right);
    }

    private static void swapNode(TreeNode root,TreeNode left, TreeNode right) {
        if(root==null) return;
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
    }
}
