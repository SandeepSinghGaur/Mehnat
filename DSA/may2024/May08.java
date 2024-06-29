package DSA.may2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class May08 {
    public static void main(String[] args) {
        int[] score = new int[]{10,3,8,9,4};
        String[] ans = findRelativeRanks(score);
        for(String res:ans){
            System.out.println(res);
        }
    }
    public static String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        int b[] = Arrays.copyOf(score, score.length);
        Arrays.sort(b);
        Map<Integer,String> hm = new HashMap<>();
        for(int i= score.length-1;i>=0;i--){
            if(i==score.length-1){
                hm.put(b[i],"Gold Medal");
            }else if(i==score.length-2){
                hm.put(b[i],"Silver Medal");
            }else if(i==score.length-3){
                hm.put(b[i],"Bronze Medal");
            }else{
               hm.put(b[i],Integer.toString(score.length-i));
            }
        }
        for(int i=0;i<score.length;i++){
            String val = hm.get(score[i]);
            ans[i]=val;
        }

        return ans;

    }
}
