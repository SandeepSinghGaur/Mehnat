package daily.dp;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3};
        List<List<Integer>> ans = permute(nums);
        for(List<Integer>list:ans){
            for(int ele : list){
                System.out.print(STR."\{ele} ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getAllPermute(nums,ans,0);
        return ans;
    }

    private static void getAllPermute(int[] nums, List<List<Integer>> ans, int i) {
        if(i==nums.length){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int k=0;k<i;k++){
                temp.add(nums[k]);
            }
            ans.add(temp);
            return ;
        }
        for(int j = i;j<nums.length;j++){
            swapArray(i,j,nums);
            getAllPermute(nums,ans,i+1);
            swapArray(j,i,nums);
        }
    }
    private static void swapArray(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
