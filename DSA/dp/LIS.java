package DSA.dp;

public class LIS {
    public static void main(String[] args) {
        int[] arr = new int[]{10,3,12,7,2,9,11,20,11,13,6,8};
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = 1;
        int ans = getLIS(arr,dp);
        //System.out.println(STR."Length of Longest Increasing SubSequence \{ans}");
    }

    private static int getLIS(int[] arr, int[] dp) {
        for(int i=1;i<arr.length;i++){
            int v = 0;
            for(int j =0;j<i;j++){
                if(arr[j]<arr[i]){
                    v = Math.max(v,arr[j]);
                }
            }
            dp[i] = v+1;
        }
        return dp[arr.length-1];
    }
}
