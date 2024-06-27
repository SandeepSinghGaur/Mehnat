package m2P.L2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeArray {


    public static void main(String[] args) {
        int [] arr = new int[]{9,9,1};
       List<Integer> ans = addOneArray(arr);
        Collections.reverse(ans);
        for(int i : ans){
            System.out.printf(""+" "+i);
        }


    }

    private static List<Integer> addOneArray(int[] arr) {
        int carry = 1;
        int n = arr.length-1;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=n ; i>=0;i--){
          if(arr[i]+carry>=10){
              ans.add(0);
              carry = 1;
          }else{
              ans.add(arr[i]+carry);
              carry = 0;
          }
        }
        if(carry == 1){
            ans.add(1);
        }
        return ans;
    }

    // 1,2,3,==>+1==> 1,2,4
    // 1,2,9==> +1==>     130
    // 9,9,9 ==> +1==> 1000
}
