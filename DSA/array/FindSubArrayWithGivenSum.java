package DSA.array;

/*
   By Using Sliding Window Technique
 */
public class FindSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        int[] ans = findSubArray(arr,sum);

        for(int i=ans[0];i<=ans[1];i++){
            System.out.printf(STR." \{arr[i]} ");
        }

    }

    private static int[] findSubArray(int[] arr, int sum) {
        int count = 0;
        int low = 0;
        for(int i=0;i< arr.length;i++){
            if(count<sum){
                count+=arr[i];
            }
            if(count>sum){
                count-=arr[low];
                low++;
            }
            if(count==sum){
                return new int[]{low,i};
            }
        }
        return new int[]{-1,-1};
    }
}
