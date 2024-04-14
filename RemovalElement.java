public class RemovalElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int k = removeElement(nums,val);
        for(int i=0;i<k;i++){
            System.out.print(nums[i]);
            System.out.printf(" ");

        }

    }

    private static int removeElement(int[] nums, int val) {
        int ans=0;
        int p1 = 0;
        int p2 = nums.length-1;
        while(p1<=p2){
            if(nums[p1]==val && nums[p2]!=val){
                swap(p1,p2,nums);
                p1++;
                p2--;
            }else if(nums[p1]==val && nums[p2]==val){
                p2--;
            }else{
                p1++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                ans++;
            }
        }
        return nums.length-ans;
    }
    private static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
