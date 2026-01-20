package DSA.array;

public class JumpGame {
    public static void main(String[] args) {
     int [] nums = {3,2,1,0,4};
     boolean ans = jumpGame(nums);
        System.out.println("we reached at last::"+ans);
    }

    private static boolean jumpGame(int[] nums) {
        int goal = nums.length-1;
        for(int i=goal-1;i>=0;i--){
            if(nums[i]+i>=goal){
                goal = i;
            }
        }
        return goal==0;
    }
}
