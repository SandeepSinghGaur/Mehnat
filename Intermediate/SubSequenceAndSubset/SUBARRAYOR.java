package Intermediate.SubSequenceAndSubset;

/*
Problem Constraints
1 <= N <= 10^5

1 <= A[i] <= 10^8
 */
public class SUBARRAYOR {
    public static void main(String[] args) {
        int[] A = new int[]{7, 8, 9, 10};
        System.out.println(subbArrayOr(A));

    }

    private static int subbArrayOr(int[] A) {
        int n = A.length;
        int[] idx = new int[32];
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            long tmp = A[i - 1];
            for (int j = 0; j <= 31; ++j) {
                long pw = 1 << j;//
                if ((tmp & pw) != 0) { //if jth bit is set
                    ans += pw * i; // add its contribution in ans for all subarrays ending at index i
                    idx[j] = i; // store the index for next elements
                } else if (idx[j] != 0) // if jth bit is not set
                {
                    ans += pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using
                } // the information of last element having jth bit set
            }
        }
        return (int)(ans % 1000000007);
    }
}
