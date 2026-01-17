package DSA.dp;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String s1 = "abbcdgf";
        String s2 = "bachegf";
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = getLCS(s1,s2,n-1,m-1,dp);
        //System.out.println(STR."Length of LCS \{ans}");

    }

    private static int getLCS(String s1, String s2, int i, int j, int[][] dp) {
        if(i==-1 || j==-1) return 0;
        if(dp[i][j]==-1){
            if(s1.charAt(i)==s2.charAt(j)){
                dp[i][j] = 1+getLCS(s1,s2,i-1,j-1,dp);
            }else{
                dp[i][j] = Math.max(getLCS(s1,s2,i-1,j,dp),getLCS(s1,s2,i,j-1,dp));
            }
        }
        return dp[i][j];
    }

}
