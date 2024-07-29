package DSA.tree.level1;

import DSA.tree.TreeNode;

public class DiameterOfBinaryTree {
    private static int diameter;
    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree(new Object[]{1,2,3,4,5});
        diameter = 0;
        int ans = calculateDiameter(root);
        System.out.println(STR."Diameter of Binary Tree:  \{diameter}");
    }

    private static int calculateDiameter(TreeNode root) {
        if(root==null) return 0;
        int leftDepth = calculateMaxDepth(root.left);
        int rightDepth = calculateMaxDepth(root.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static int calculateMaxDepth(TreeNode left) {
        if(left==null) return 0;
        int leftTree = 1+calculateMaxDepth(left.left);
        int rightTree = 1+calculateMaxDepth(left.right);
        return Math.max(leftTree,rightTree);
    }
}
