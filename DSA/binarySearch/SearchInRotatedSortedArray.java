package DSA.binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{ 4,5,6,7,0,1,2}; // 4567 // 012
        int target = 1;
        int ans = search(nums,target);
        System.out.println("postion of the element:: "+ans);

    }

    public static int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid= (low + high) /2;
            if(nums[mid]==target) return mid;
            //check if left half is sorted
            if(nums[low]<=nums[mid]){
                //check if target lies on the left half
                if(target<=nums[mid] && target>=nums[low]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            //check if right half is sorted
            else{
                if(target>=nums[mid] && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
