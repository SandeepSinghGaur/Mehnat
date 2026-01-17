package DSA.tree.level1;

import DSA.tree.TreeNode;

/*
   Time Complexity: O(N)
   Auxiliary Space: O(N)
 */
public class BTHeight {
    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree(new Object[]{1,null,2});
        int height = maxDepth(root);
        //System.out.println(STR."Height of Binary Tree : \{height}");
    }

    private static int maxDepth(TreeNode root) {
        // apply DFS
        if(root==null) return 0;
        int leftSubtree = 1+maxDepth(root.left);
        int rightSubTree = 1+maxDepth(root.right);
        return Math.max(leftSubtree,rightSubTree);
    }

}
