package DSA.dp;

public class MaxSubSequenceSumNotPickedTwoAdjacentElement {
    public static void main(String[] args) {
        int[] arr = new int[]{2,-1,-4,5,3,-1,4,2};
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0],dp[1]);
        int ans = maxSubSum(arr,dp);
        System.out.println("MaxSubSequenceSumNotPickedTwoAdjacentElement::"+ans);
    }

    private static int maxSubSum(int[] arr, int[] dp) {
        for(int i=2;i<arr.length;i++){
            dp[i] = Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        return dp[arr.length-1];
    }
}
