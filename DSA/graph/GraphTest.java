public class GraphTest {
    public static void main(String[] args) {
        System.out.println("Testing Graph Implementation...");

        // Create a graph with 5 vertices
        Graph g = new Graph(5);

        // Add some edges
        // 0 -> 1, 4
        g.addEdge(0, 1);
        g.addEdge(0, 4);

        // 1 -> 2, 3, 4
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        // 2 -> 3
        g.addEdge(2, 3);

        // 3 -> 4
        g.addEdge(3, 4);

        System.out.println("Adjacency List:");
        g.printGraph();

        System.out.println("\nTesting Directed Edge:");
        Graph directedG = new Graph(3);
        directedG.addEdge(0, 1, true); // 0 -> 1
        directedG.printGraph();
    }
}
