package coreJava.stream.comparator.sortMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CustomeSortingPriorityQueue {



    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4},{4,6},{5,6}};
        HashMap<Integer,Integer> hm = new HashMap<>();
        createMap(hm);
        System.out.println("===============Priority Queue on int[]====================");
       priorityQueueOnArray(arr);
        System.out.println("===============Priority Queue on Map.Entry<Integer, Integer>====================");
        priorityQueueOnMap(hm);
    }

    private static void priorityQueueOnMap(HashMap<Integer, Integer> hm) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
                Comparator.comparing((Map.Entry<Integer, Integer> e) -> e.getKey()).reversed()
        );
        for(Map.Entry<Integer,Integer> ele : hm.entrySet()){
            pq.add(ele);
        }
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> ele = pq.poll();
            System.out.println(ele.getKey() +"::"+ele.getValue());
        }
    }


    private static HashMap<Integer,Integer> createMap(HashMap<Integer,Integer>hm) {
        hm.put(1,2);
        hm.put(1,7);
        hm.put(2,9);
        hm.put(9,7);
        hm.put(0,2);
        return hm;
    }

    private static void priorityQueueOnArray(int[][] arr) {
        // always remeber in java by default priority queue give us min heap
        //max heap on array second element ==> so we did reversed()
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                        Comparator.comparing((int[] a) -> a[1]).reversed());
        for (int[] ele : arr) {
          pq.offer(ele);
        }
        while(!pq.isEmpty()){
            int[] ele = pq.poll();
            System.out.println(ele[0] +"::"+ele[1]);
        }
    }
}
