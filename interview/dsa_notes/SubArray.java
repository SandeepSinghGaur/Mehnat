package interview.dsa_notes;

public class SubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,-2};
        printSubArray(arr);
        printMaxSubArraySum(arr);
        sumOfAllSubArray(arr);
        sumOfAllSubArrayUsingContributionTechnique(arr);
        maxSubArraySumUsingKadane(arr);


    }

    private static void maxSubArraySumUsingKadane(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<n;i++){
            count+=arr[i];
            if(maxSum<count){
                maxSum = count;
            }
            if(count<0){
                count = 0;
            }

        }
        System.out.println(STR."Max SubArray Sum \{maxSum}");
    }

    private static void sumOfAllSubArrayUsingContributionTechnique(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=(i+1)*(n-i)*arr[i];
        }
        System.out.println(STR."Using Contribution Techniques Sum of All SubArray \{sum}");
    }

    private static void printMaxSubArraySum(int[] arr) {
        int n = arr.length;
        int maxSubArraySum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum+=arr[j];
                maxSubArraySum = Math.max(sum,maxSubArraySum);
            }
        }
        System.out.println(STR."Max SubArray Sum \{maxSubArraySum}");
    }

    private static void sumOfAllSubArray(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=i;j<n;j++){
              count+=arr[j];
              sum+=count;
            }
        }
        System.out.println(STR."Sum of All SubArray \{sum}");
    }

    private static void printSubArray(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                count++;
                System.out.println();
            }
        }
        System.out.println(STR."No of SubArray \{count}");
    }


}
