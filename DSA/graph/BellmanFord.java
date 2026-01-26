/*
Given a weighted graph with V vertices and E edges, along with a source vertex src, 
the task is to compute the shortest distances from the source to all other vertices. 
If a vertex is unreachable from the source, its distance should be marked as 10^8. 
In the presence of a negative weight cycle, return -1 to signify that shortest path calculations are not feasible.

Input: V = 5, edges = [[0, 1, 5], [1, 2, 1], [1, 3, 2], [2, 4, 1], [4, 3, -1]], src = 0
 */

import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{ 0, 1, 5 },{ 1, 2, 1 },{ 1, 3, 2 },{ 2, 4, 1 },{ 4, 3, -1 }};
        int src = 0;
        int[] ans = bellmanFord(V, edges, src);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000); // Initialize with 10^8 as per requirement
        dist[src] = 0;

        // Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != 100000000 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for negative weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] != 100000000 && dist[u] + w < dist[v]) {
                return new int[] { -1 };
            }
        }

        return dist;
    }
}
