package DSA.array.intervals;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes1 = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        System.out.println("Output: " + maxEnvelopes(envelopes1));
    }

    private static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;

        // Sort by width asc, height desc
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        // LIS on heights
        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] env : envelopes) {
            int h = env[1];
            int idx = Arrays.binarySearch(dp, 0, len, h);
            if (idx < 0)
                idx = -(idx + 1);
            dp[idx] = h;
            if (idx == len)
                len++;
        }
        return len;
    }
}
