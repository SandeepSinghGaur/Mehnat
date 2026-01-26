import java.util.Arrays;

public class UnionFind {
  public static void main(String[] args) {
        int[][] edges = {{1,4,6},{3,3,4},{5,7,8},{5,2,7},{6,3,2},{8,6,8},{11,1,5},{10,9,6},{11,1,5},{12,7,9},{14,5,10},{20,6,10}};
        int n = 10;
        int ans = findMinimumSpanningTree(n,edges);
        System.out.println("Minimum Spanning Tree: "+ans);
        
    }

    private static int findMinimumSpanningTree(int n, int[][] edges) {
        int ans = 0;
        // 1. Sort the edges based on weight
        Arrays.sort(edges,(a,b)->a[0]-b[0]);
        Arrays.stream(edges).forEach(edge->System.out.println(edge[0]+" "+edge[1]+" "+edge[2]));
        // 2. take an array of size n+1 of Component
        int[] components = new int[n+1];
        for(int i=1;i<=n;i++){
            components[i] = i;
        }
        // 3. Iterate through edges and add them to the MST if they don't form a cycle
        for(int[] edge : edges){
            int w = edge[0];
            int u = edge[1];
            int v = edge[2];
            if(!isCycle(components,u,v)){
                ans += w;
            }
        }
        return ans;
        
    }

    private static boolean isCycle(int[] components, int u, int v) {
        int x =unionFind(components,u) ;
        int y= unionFind(components,v);
        if(x!=y){
            components[Math.max(x,y)] = components[Math.min(x,y)];
            return false;
        }
        return true;
    }

    private static int unionFind(int[] components, int u) {
        if(components[u] == u){
            return u;
        }
       components[u] = unionFind(components,components[u]);
       return components[u];
    }
}
