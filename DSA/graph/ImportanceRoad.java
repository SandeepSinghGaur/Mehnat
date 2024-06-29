package DSA.graph;

import java.util.ArrayList;

public class ImportanceRoad {
    public static void main(String[] args) {
        int n = 5; //[[2,9],[7,8],[5,9],[7,2],[3,8],[2,8],[1,6],[3,0],[7,0],[8,5]]
        int[][] roads = {
                {0,1},
                {1,2},
                {2,3},
                {0,2},
                {1,3},
                {2,4}
        };
        long ans = maximumImportance(n,roads);
    }

    private static long maximumImportance(int n, int[][] roads) {
        ArrayList<Integer>[] ad = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i <n; i++) {
            ad[i] = new ArrayList<>();
        }
        int[] incommingEdge = new int[n];
        for(int [] row : roads){
            int u = row[0];
            int v = row[1];
            ad[u].add(v);
            ad[v].add(u);
            incommingEdge[u]++;
            incommingEdge[v]++;
        }
        for(int i=0;i<ad.length;i++){
            System.out.printf(STR."\{i}  -> < ");
            for(int j =0;j<ad[i].size();j++){
                System.out.printf(STR."  \{ad[i].get(j)} ");
            }
            System.out.printf(">");
            System.out.println();
        }
        System.out.println("======================================");
        for(int val : incommingEdge){
            System.out.printf(" "+val);
        }
        System.out.println();
        return 0;
    }
}
