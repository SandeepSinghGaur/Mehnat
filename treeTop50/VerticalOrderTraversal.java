package treeTop50;
import java.util.*;
public class VerticalOrderTraversal {

        public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
            return vot(A);
        }

        private ArrayList<ArrayList<Integer>> vot(TreeNode A) {
            if (A == null) return new ArrayList<>();

            int maxL = 0;
            int minL = 0;
            HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
            Queue<Pair> queue = new LinkedList<>();

            queue.add(new Pair(A, 0));

            while (!queue.isEmpty()) {
                Pair current = queue.poll();
                TreeNode node = current.first;
                int level = current.second;

                if (!mp.containsKey(level)) {
                    mp.put(level, new ArrayList<>());
                }
                mp.get(level).add(node.val);

                if (node.left != null) {
                    queue.add(new Pair(node.left, level - 1));
                    minL = Math.min(minL, level - 1);
                }

                if (node.right != null) {
                    queue.add(new Pair(node.right, level + 1));
                    maxL = Math.max(maxL, level + 1);
                }
            }

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = minL; i <= maxL; i++) {
                result.add(mp.get(i));
            }

            return result;
        }

        static class Pair {
            TreeNode first;
            int second;

            public Pair(TreeNode first, int second) {
                this.first = first;
                this.second = second;
            }
        }

    // Assume TreeNode class is defined as follows:
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

}
