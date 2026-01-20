package DSA.array.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class MergeInterval {
    public static void main(String[] args) {
        int [][] intervals ={{1,4},{4,5}};
        int [][] ans = mergeInterval(intervals);
        for(int [] a : ans){
            System.out.println(" "+a[0] +" "+a[1]);
        }

    }

    private static int[][] mergeInterval(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a->a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (prev[1] < next[0]) {
                merged.add(prev);
                prev = next;
            }else{
                prev[1] = Math.max(prev[1], next[1]);
            }
        }

        merged.add(prev);
        // convert list to array
        return merged.toArray(new int[merged.size()][]);
    }
}
