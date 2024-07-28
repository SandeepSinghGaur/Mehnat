package DSA.tree;

public class SumOfLeftLeaves {
    private static int count=0;
    public static void main(String[] args) {
        //ArrayList<?> root = (ArrayList<?>) Arrays.asList(3,9,20,null,null,15,7);
        TreeNode root = makeTree();
        traverseTree(root);
        System.out.println(sumOfLeftLeaves(root));
        //System.out.println(STR."Count \{count}");
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int sum = 0;
        if(root.left!=null && root.left.left==null && root.left.right==null){
            sum+=root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }

    private static void traverseTree(TreeNode root) {
          TreeNode temp = root;
          if(temp==null) return;
            System.out.println(temp.val);
            traverseTree(temp.left);
            traverseTree(temp.right);
    }

    public static TreeNode makeTree() {
       TreeNode node1 = new TreeNode(3);
       TreeNode node2 = new TreeNode(9);
       TreeNode node3 = new TreeNode(20);
       node1.left = node2;
       node1.right = node3;
       node3.left = new TreeNode(15);
       node3.right = new TreeNode(7);
       return node1;
    }
}
