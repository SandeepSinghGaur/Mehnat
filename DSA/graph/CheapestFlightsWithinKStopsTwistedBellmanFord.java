import java.util.Arrays;

public class CheapestFlightsWithinKStopsTwistedBellmanFord {
    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int n = 3;
        int src = 0;
        int dst = 2;
        int k = 1;
        int ans = findCheapestFlightsWithinKStops(n,flights,src,dst,k);
        System.out.println("Cheapest Flights Within "+k+" Stops: "+ans);
    }

    private static int findCheapestFlightsWithinKStops(int n, int[][] flights, int src, int dst, int k) {
        // Use a large value, but not MAX_VALUE to avoid overflow
        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // We can take at most k+1 edges
        for (int i = 0; i <= k; i++) {
            // Create a copy to prevent using updated values from the current level
            long[] tmpDist = Arrays.copyOf(dist, n);
            
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];
                
                // If we've reached city 'u' in previous steps
                if (dist[u] != Integer.MAX_VALUE) {
                    if (dist[u] + price < tmpDist[v]) {
                        tmpDist[v] = dist[u] + price;
                    }
                }
            }
            // Update original dist with the results of this level
            dist = tmpDist;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : (int) dist[dst];
        
    }

}
