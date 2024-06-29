package company_interview.m2P.L2;

public class Question2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1 ,2,3,4,5};
        /*   count = 0;
             for i=0;
              count = count+arr[i];
              if(ans<count)
              ans = Math.max(count,ans);
              if(count<0) count = 0;

         */
        int ans = maxSubArray(arr);
        System.out.println(STR."Max SubArray Sum \{ans}");

    }

    private static int maxSubArray(int[] arr) {
        int ans = Integer.MIN_VALUE;
//        for(int i =0;i<=arr.length-1;i++){
//            int sum = 0;
//            for(int j = i;j<=arr.length-1;j++){
//                sum+=arr[j];
//                ans = Math.max(ans,sum);
//            }
//        }
        int count = 0;
        for(int i =0;i<arr.length;i++){
            count+= arr[i];
            ans = Math.max(ans,count);
            if(count<0) count = 0;
        }

        return ans;

    }
}
