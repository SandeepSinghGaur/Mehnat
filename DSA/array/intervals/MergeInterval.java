package DSA.array.intervals;

import java.util.Arrays;
import java.util.Comparator;

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
        int[][] ans = new int[intervals.length][2];

        int count = 0;
       for(int i=0;i<intervals.length;i++){
           int[] prev = intervals[i];
           if(i== intervals.length-1){
               int [] arr = new int[]{prev[0],prev[1]};
               ans[count] = arr;
               count++;
               i++;
               break;
           }
           int[] next = intervals[i+1];
           int k = i+1;
           //overlap
           while(prev[1]>=next[0]){
               int newMin = Math.min(prev[0],next[0]);
               int newMax = Math.max(prev[1],next[1]);
               prev[0] = newMin;
               prev[1] = newMax;
               if(k+1<intervals.length){
                   next=intervals[k+1];
                   k++;
               }else{
                   int [] arr = new int[]{prev[0],prev[1]};
                   ans[count] = arr;
                   count++;
                   k++;
                   break;
               }
           }
           if(prev[1]<next[0]){
               int [] arr = new int[]{prev[0],prev[1]};
               ans[count] = arr;
               count++;
           }
           i=k-1;

       }
        System.out.println(STR."count \{count}");
       int[][] finalResult = new int[count][2];
       for(int i=0;i<count;i++){
           finalResult[i][0] = ans[i][0];
           finalResult[i][1] = ans[i][1];
       }
       return  finalResult;
    }
}
