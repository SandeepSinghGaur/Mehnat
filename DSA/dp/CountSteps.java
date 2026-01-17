package DSA.dp;

import java.util.Arrays;

public class CountSteps {
    public static void main(String[] args) {
        int n = 4;
        int ans = noOfWays(n);
        //System.out.println(STR."Total way to reach top \{ans}");
    }

    private static int noOfWays(int n) {
        int[] dp = new int[n+1];
        System.out.println(dp.length);
        Arrays.fill(dp,-1);
        return noOfStair(n,dp);

    }

    private static int noOfStair(int i, int[] dp) {
        if(i<=1) return 1;
        if(dp[i]==-1){
            dp[i] = noOfStair(i-1,dp)+noOfStair(i-2,dp);
        }
        return dp[i];
    }
}
