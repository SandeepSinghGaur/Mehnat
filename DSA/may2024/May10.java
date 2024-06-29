package DSA.may2024;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;
import java.util.PriorityQueue;

public class May10 {


    public static void main(String[] args) {
        int [] arr = new int[]{1,29,47};
        int k =1;
        int [] res = kthSmallestPrimeFraction(arr, k);
        for(int i:res){
            System.out.println(i +" ");
        }
    }


    private static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        int k1 = (n*(n+1))/2;
        PriorityQueue<Map.Entry<BigDecimal, int[]>> pq = new PriorityQueue<>(k1, (a, b) -> a.getKey().compareTo(b.getKey()));
        MathContext mc = new MathContext(34); // 34 digits of precision

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                BigDecimal val = BigDecimal.valueOf(arr[i]).divide(BigDecimal.valueOf(arr[j]), mc.DECIMAL128); // Adjust scale and rounding mode as needed
                int[] local = new int[]{arr[i], arr[j]};
                pq.add(Map.entry(val, local));
            }
        }

        int count =1;
        while(pq.size()>0){
            if (count==k){
                return pq.peek().getValue();
            }
            count++;
            pq.poll();

        }
        return new int[]{0,0};
    }
}
