package DSA.graph;

import java.util.ArrayList;

public class Problem01Dfs {
    public static void main(String[] args) {
        int n = 10; //[[2,9],[7,8],[5,9],[7,2],[3,8],[2,8],[1,6],[3,0],[7,0],[8,5]]
        int[][] edges = {
                {2, 9},
                {7, 8},
                {5, 9},
                {7, 2},
                {3, 8},
                {2, 8},
                {1, 6},
                {3, 0},
                {7, 0},
                {8, 5}
        };
        int s = 1;
        int d = 0;
        /*
          Adjency List
          0-><3,7>
          1-><6>
          2-><9,7,8>
          3-><8,0>
          5-><9,8>
          6-><1>
          7-><8,2,0>
          8-><7,3,2,5>
          9-><2,5>






         */
        boolean ans = findValidPathUsingDfs(n,edges,s,d);
       // System.out.println(STR."Valid Path: \{ans}");
    }

    private static boolean findValidPathUsingDfs(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] ad = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            ad[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            ad[u].add(v);
            ad[v].add(u);
        }
        for(int i=0;i<ad.length;i++){
            //System.out.printf(STR."\{i}  -> < ");
            for(int j =0;j<ad[i].size();j++){
               // System.out.printf(STR."  \{ad[i].get(j)} ");
            }
            System.out.printf(">");
            System.out.println();
        }
        boolean isVisited[] = new boolean[n+1];
        dfs(ad,isVisited,source,destination);
        return isVisited[destination];
    }

    private static void dfs(ArrayList<Integer>[] ad, boolean[] isVisited, int source, int destination) {
        if(isVisited[source] || isVisited[destination]) return;
        isVisited[source]=true;
        for(int i=0;i<ad[source].size();i++){
            dfs(ad,isVisited,ad[source].get(i),destination);
        }

    }
}
