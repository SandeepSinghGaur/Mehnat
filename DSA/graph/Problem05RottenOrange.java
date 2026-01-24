package DSA.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Problem05RottenOrange {
    public static void main(String[] args) {
        /*
          0-> empty cell
          1-> fresh orange
          2-> rotten orange
         */
        int[][] grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        int ans = orangesRotting(grid);
        System.out.println("Time taken to whole orange rotten::"+ans);

    }

    private static int orangesRotting(int[][] grid) {
        int m = grid.length; // row
        int n = grid[0].length; // col
        int[][]time = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        boolean checkRottenOrange = true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    checkRottenOrange = false;
                    q.add(new Pair(i,j));
                    time[i][j] = 0;
                }
            }
        }
        if(checkRottenOrange) return -1;

        int[] x = new int[]{-1,1,0,0};
        int[] y = new int[]{0,0,-1,1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.first;
            int j = p.second;
            for(int k=0;k<4;k++){
                int a = i + x[k];
                int b = j + y[k];
                if(a>=0 && b>=0 && a<grid.length && b< grid[0].length && grid[a][b]==1){
                    grid[a][b] = 2;
                    time[a][b] = time[i][j]+1;
                    q.add(new Pair(a,b));
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i< time.length;i++){
            for(int j=0;j<time[i].length;j++){
                System.out.printf(" %d ",time[i][j]);
                ans = Math.max(ans,time[i][j]);
            }
            System.out.println();

        }
        return ans;

    }


    public static class Pair{
        int first;
        int second;
        Pair(int i,int j){
            this.first  = i;
            this.second = j;
        }
    }
}
