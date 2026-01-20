package DSA.array.intervals;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks1 = {'A','A','A','B','B','B'};
        int n1 = 2;
        int ans = leastInterval(tasks1, n1);
        System.out.println("ANSWER:: "+ans);
    }

    private static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);

        int max = freq[25] - 1;
        int idle = max * n;

        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idle -= Math.min(max, freq[i]);
        }

        return idle > 0 ? idle + tasks.length : tasks.length;
    }
}
