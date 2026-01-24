import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    // HashMap to keep track of visited nodes and their clones
    private HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If we have already visited/cloned this node, return the clone
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        // 1. Create a copy (clone) of the node
        Node clone = new Node(node.val);

        // 2. Put it in the map immediately (CRITICAL for handling cycles)
        map.put(node.val, clone);

        // 3. Iterate through neighbors and clone them recursively
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    public static void main(String[] args) {
        // Constructing the graph Example: 1 -- 2
        // | |
        // 4 -- 3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        CloneGraph solution = new CloneGraph();
        Node clonedStart = solution.cloneGraph(n1);

        System.out.println("Original Node 1 HashCode: " + System.identityHashCode(n1));
        System.out.println("Cloned Node 1 HashCode: " + System.identityHashCode(clonedStart));

        System.out.println("Graph Traversal:");
        printGraph(clonedStart);
    }

    private static void printGraph(Node node) {
        if (node == null)
            return;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited.add(node.val);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print("Node " + curr.val + " neighbors: ");
            for (Node n : curr.neighbors) {
                System.out.print(n.val + " ");
                if (!visited.contains(n.val)) {
                    visited.add(n.val);
                    q.add(n);
                }
            }
            System.out.println();
        }
    }
}
