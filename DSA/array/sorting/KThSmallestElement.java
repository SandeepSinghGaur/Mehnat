package DSA.array.sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class KThSmallestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        int k = 4;
        int ans = kthSmallestElement(arr,k);
        System.out.println(STR."kth Smallest Element:  \{ans}");
    }

    private static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele:arr){
            pq.add(ele);
        }
        while(!pq.isEmpty() && k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}
