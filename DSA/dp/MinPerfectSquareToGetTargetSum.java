package DSA.dp;

import java.util.Arrays;

public class MinPerfectSquareToGetTargetSum {
    public static void main(String[] args) {
        int n = 10;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = minPQ(n,dp);
        System.out.println(STR."Min Perfect Square \{ans}");
    }

    private static int minPQ(int n, int[] dp) {
        dp[0] = 0;
        for(int i =1;i<=n;i++){
            int ans = i;
            for(int j = 1;j*j<=i;j++){
                ans = Math.min(ans,dp[i-j*j]+1);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}
