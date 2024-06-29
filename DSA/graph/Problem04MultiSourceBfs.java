package DSA.graph;


import java.util.*;

public class Problem04MultiSourceBfs {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 11},
                {11, 6},
                {11, 5},
                {5, 2},
                {5, 4},
                {2, 3},
                {4, 8},
                {3, 12},
                {3, 9},
                {8, 7},
                {9, 13},
                {7, 10},
                {13, 10}
        };
        int n = 13;
        int[] source = new int[]{11, 7, 2};
        int[] shortestPaths = multiSourceBfs(grid, source, n);

        // Print the shortest path lengths
        System.out.println("Shortest path lengths from any node to the nearest source node:");
        for (int i = 1; i <= n; i++) {
            System.out.printf("Node %d: %d\n", i, shortestPaths[i]);
        }
    }

    private static int[] multiSourceBfs(int[][] grid, int[] source, int n) {
        ArrayList<Integer>[] ad = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            ad[i] = new ArrayList<>();
        }
        for (int i = 0; i < grid.length; i++) {
            int u = grid[i][0];
            int v = grid[i][1];
            ad[u].add(v);
            ad[v].add(u);
        }

        for (int i = 0; i < ad.length; i++) {
            System.out.printf("%d -> ", i);
            for (int j = 0; j < ad[i].size(); j++) {
                System.out.printf("%d ", ad[i].get(j));
            }
            System.out.println();
        }

        // Initialize the queue and distances array
        Queue<Integer> q = new LinkedList<>();
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Add all source nodes to the queue and set their distances to 0
        for (int s : source) {
            q.add(s);
            distances[s] = 0;
        }

        // Perform BFS
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.println(STR."Visited node: \{node}");

            for (int neighbor : ad[node]) {
                if (distances[neighbor] == Integer.MAX_VALUE) {
                    q.add(neighbor);
                    distances[neighbor] = distances[node] + 1;
                }
            }
        }

        return distances;
    }
}

