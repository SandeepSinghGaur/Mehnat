
import java.util.Arrays;

public class ImportanceRoad2285 {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 2 }, { 1, 3 }, { 2, 4 } };
        long ans = maximumImportance(n, roads);
        System.out.println("Maximum Importance: " + ans);
    }

    private static long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        // 1. Calculate the degree of each node
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // 2. Sort the degrees in ascending order
        // Logic: Assign the highest values to the nodes with the highest degrees
        // to maximize the total sum.
        Arrays.sort(degree);
        System.out.println(Arrays.toString(degree));

        long ans = 0;
        // 3. Calculate total importance
        // degree[i] is the degree of a node. We assign it value (i+1).
        // Since we sorted, degree[0] is the smallest degree (gets value 1),
        // degree[n-1] is the largest degree (gets value n).
        for (int i = 0; i < n; i++) {
            ans += degree[i] * (i + 1);
        }

        return ans;
    }
}
