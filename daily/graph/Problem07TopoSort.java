package daily.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem07TopoSort {
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {
                {2, 1}, // it means from node 2 to 1 there is an edge
                {2, 3},
                {2, 7},
                {3, 4},
                {3, 5},
                {3, 7},
                {7, 6},
                {7, 5},
                {8, 2},
                {9, 1},
                {10,3}
        };
      createAdjancencyList(n,edges);
    }

    private static void createAdjancencyList(int n, int[][] edges) {
        ArrayList<Integer>[] ad = (ArrayList<Integer>[] ) new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            ad[i] = new ArrayList<>();
        }
        for(int i=0;i<=n;i++){
            int u = edges[i][0];
            ad[u].add(edges[i][1]);
        }
        for(int i=0;i<ad.length;i++){
            if(ad[i].size()==0){
                ad[i].add(0);
            }
        }
        topoSort(n,ad);
        return;
    }

    private static void topoSort(int n, ArrayList<Integer>[] ad) {
        int[] incommingEdge = new int[n+1];
        for(int i=0;i< ad.length;i++){
            for(int j=0;j<ad[i].size();j++){
                int val = ad[i].get(j);
                if(val!=0)
                incommingEdge[val] = incommingEdge[val]+1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(incommingEdge[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int ele = q.poll();
            System.out.printf(ele+" ");
            for(int i=0;i<ad[ele].size();i++){
                int v = ad[ele].get(i);
                incommingEdge[v]--;
                if(incommingEdge[v]==0){
                    q.add(v);
                }
            }
        }
    }
}
