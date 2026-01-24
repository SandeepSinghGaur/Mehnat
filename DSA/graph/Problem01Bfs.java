package DSA.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem01Bfs {
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{2, 9},{7, 8},{5, 9},{7, 2},{3, 8},{2, 8},{1, 6},{3, 0},{7, 0},{8, 5}};
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
        boolean ans = findValidPath(n,edges,s,d);
        System.out.println("Valid Path::"+ans);
    }

    private static boolean findValidPath(int n, int[][] edges, int source, int destination) {
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
        for(int i=0;i<ad.length;i++){
            System.out.printf(i+"  -> <");
            for(int j =0;j<ad[i].size();j++){
               System.out.printf(" "+ad[i].get(j)+" ");
            }
            System.out.printf(">");
            System.out.println();
        }
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int ele = q.poll();
            for (int j = 0; j < ad[ele].size(); j++) {
                if (visited[ad[ele].get(j)] == false) {
                    q.add(ad[ele].get(j));
                    visited[ad[ele].get(j)] = true;
                }
            }
        }
        return visited[destination];
    }
}
