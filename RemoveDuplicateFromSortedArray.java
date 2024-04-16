public class RemoveDuplicateFromSortedArray {


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int k= removeDuplicate(nums);
        System.out.println(STR."K \{k}");
        for (int i=0;i<k;i++){
            System.out.print(nums[i]);
            System.out.printf(" ");
        }
    }

    private static int removeDuplicate(int[] nums) {
        int j = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
