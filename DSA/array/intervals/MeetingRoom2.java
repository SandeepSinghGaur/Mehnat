package DSA.array.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public static void main(String[] args) {
        int[][] interval = {{0, 30},
                {5, 10},
                {15, 20}};
        int ans = minMeetingRooms(interval);
        System.out.println("min Meeting Room :: "+ans);
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a->a[0]));

        /*
         PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
         */
        //Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek() <= intervals[i][0]) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}
