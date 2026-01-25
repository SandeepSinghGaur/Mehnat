
import java.util.ArrayList;

public class Graph {
    private int V;
    private ArrayList<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        // Initialize adjacency list
        // Note: Creating an array of ArrayLists requires a cast
        this.adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new ArrayList<>();
        }
    }

    // Add edge
    public void addEdge(int u, int v, boolean isDirected) {
        // Add edge from u to v
        // Check bounds just in case, though usually we assume valid input in DSA
        // problems
        if (u >= 0 && u < V && v >= 0 && v < V) {
            adj[u].add(v);
            if (!isDirected) {
                adj[v].add(u);
            }
        } else {
            System.err.println("Error: Vertices " + u + " or " + v + " out of bounds for graph size " + V);
        }
    }

    // Valid for 1-based indexing if size was initialized as n+1
    public void addEdge(int u, int v) {
        addEdge(u, v, false); // Default to undirected
    }

    public ArrayList<Integer>[] getAdjacencyList() {
        return adj;
    }

    public int getV() {
        return V;
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Integer neighbor : adj[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
