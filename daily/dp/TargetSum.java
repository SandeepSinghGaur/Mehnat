//package daily.dp;
//
//public class TargetSum {
//    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,1,1,1};
//        int target = 3;
//        int result = findTargetSumWays(nums,target);
//        System.out.println(STR."Result \{result}");
//    }
//
//    private static int findTargetSumWays(int[] nums, int target) {
//        int i =0;
//        int sum = 0;
//        int ans = 0;
//        findTargetSum(nums,i,sum,ans,target);
//        return ans;
//    }
//    private static void findTargetSum(int[] nums, int i, int sum, int ans, int target){
//        if(i==nums.length && sum==target){
//            ans++;
//            return;
//        }else if(i==nums.length && sum!=target){
//            return;
//        }
//        sum+=nums[i];
//        findTargetSum(nums,i+1,sum,ans,target);
//        sum=sum-nums[i]*2;
//        findTargetSum(nums,i+1,sum,ans,target);
//    }
//}


package daily.dp;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        int result = findTargetSumWays(nums, target);
        System.out.println(STR."Result: \{result}");
    }

    private static int findTargetSumWays(int[] nums, int target) {
        int[] ans = new int[1]; // Using an array to hold the answer as reference
        findTargetSum(nums, 0, 0, ans, target);
        return ans[0];
    }

    private static void findTargetSum(int[] nums, int i, int sum, int[] ans, int target){
        if (i == nums.length) {
            if (sum == target) {
                ans[0]++;
            }
            return;
        }
        sum = sum+nums[i];
        findTargetSum(nums, i + 1, sum, ans, target);
        sum = sum -nums[i]-nums[i];
        findTargetSum(nums, i + 1, sum , ans, target);
    }
}
