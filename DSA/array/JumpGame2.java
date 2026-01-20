package DSA.array;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int ans = jump(nums);
        System.out.println("Minimum Jump:: "+ans);
    }

    private static int jump(int[] nums) {
        int jump = 0;
        int max = 0;
        int curr = 0;
        for(int i=0;i<nums.length-1;i++){
            max = Math.max(max , nums[i]+i);
            if(curr == i){
                jump++;
                curr = max;
            }
            if(curr>nums.length-1)
                return jump;
        }
        return jump;
    }
}
