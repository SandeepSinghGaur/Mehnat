package DSA.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem08CourseScheduleTopoSort {
    public static void main(String[] args) {
        int n = 2;
        int[][] prerequisites = new int[][]{
                {1,0},
                {0,1}
        };
        boolean ans = canFinish(n,prerequisites);
        //System.out.println(STR."Can finish \{ans}");
    }

    private static boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            G[i] = new ArrayList<Integer>();
        }
        int[] degree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int ele = q.poll();
            for(int i : G[ele]){
                degree[i]--;
                if (degree[i] == 0){
                    q.add(i);
                }
            }
        }

        for(int i : degree) {
            System.out.printf(" " + i);
        }
        for(int i : degree){
            if(i>0){
                return false;
            }
        }
        System.out.println();
        return true;
    }
}
