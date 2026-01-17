package DSA.dp;

import java.util.Arrays;

public class PartyPair {
    public static void main(String[] args) {
        int n = 4;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        int ans = party(n,dp);
        //System.out.println(STR."Party Pair \{ans}");
    }

    private static int party(int n, int[] dp) {
        for(int i =2;i<=n;i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        return dp[n];
    }
}
