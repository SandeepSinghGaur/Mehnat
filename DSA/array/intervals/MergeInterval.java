package DSA.array.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class MergeInterval {
    public static void main(String[] args) {
        int [][] intervals = new int[][]{{1,4},{4,5}};
        int [][] ans = mergeInterval(intervals);
        for(int [] a : ans){
            System.out.println(STR."{ \{a[0]} \{a[1]} }");
        }

    }

    private static int[][] mergeInterval(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a->a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
}
