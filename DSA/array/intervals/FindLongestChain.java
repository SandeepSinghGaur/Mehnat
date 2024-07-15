package DSA.array.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain {
    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1,2},{7,8},{4,5}};
        int ans = findLongestChain(pairs);
        System.out.println("Ans"+" "+ans);
    }

    private static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,Comparator.comparing(a->a[0]));
        int ans= 0;
        for(int i=0;i< pairs.length-1;i++){
            if(pairs[i][1]<pairs[i+1][0]){
                ans++;
            }
            System.out.println(pairs[i][0] +" "+pairs[i][1]);
        }

        return ans+1;
    }
}
