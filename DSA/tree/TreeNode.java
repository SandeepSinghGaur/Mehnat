package DSA.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    int val;
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    TreeNode(int val) { this.val = val; }
    public static TreeNode makeTree(Object[] arr){
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode((Integer) arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (arr[i] != null) {
                current.left = new TreeNode((Integer) arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode((Integer) arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}
