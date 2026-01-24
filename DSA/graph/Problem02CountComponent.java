package DSA.graph;

import java.util.ArrayList;

public class Problem02CountComponent {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1},{0, 2},{1, 2},{3, 4}};
        int ans = countCompleteComponents(n, edges);
        System.out.println("Number of connected components: "+ans);
    }

    private static int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer>[] ad = new ArrayList[n];
        for (int i = 0; i < ad.length; i++) {
            ad[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            ad[u].add(v);
            ad[v].add(u);
        }

        int count = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(ad, isVisited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(ArrayList<Integer>[] ad, boolean[] isVisited, int source) {
        if (isVisited[source]) return;
        isVisited[source] = true;
        for (int neighbor : ad[source]) {
            if (!isVisited[neighbor]) {
                dfs(ad, isVisited, neighbor);
            }
        }
    }
}
