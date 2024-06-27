package daily.array;
/*

https://leetcode.com/problems/contiguous-array/description/
https://leetcode.com/problems/subarray-sum-equals-k/description/
https://leetcode.com/problems/subarrays-with-k-different-integers/description/
https://leetcode.com/problems/count-number-of-nice-subarrays/description/
https://leetcode.com/problems/binary-subarrays-with-sum/description/
https://leetcode.com/problems/subarray-product-less-than-k/description/
https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/

 */
public class NiceSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        int ans = numberOfSubarrays(nums, k);
        System.out.println("Ans " + ans);
    }

    private static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int oddCount = 0;
        int result = 0;
        int start = 0;
        int count = 0;

        for (int end = 0; end < n; end++) {
            if (nums[end] % 2 != 0) {
                oddCount++;
                count = 0;
            }
            while (oddCount == k) {
                if (nums[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
                count++;
            }

            result += count;
        }

        return result;
    }
}
