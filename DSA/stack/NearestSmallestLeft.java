package DSA.stack;

import java.util.Stack;

public class NearestSmallestLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,10,12,6,1};
        int[] ans = NearestSmallerLeftForEveryElement(arr);
        for (int ele : ans){
           // System.out.printf(STR." \{ele} ");
        }
    }

    private static int[] NearestSmallerLeftForEveryElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=0;i< arr.length;i++){
            while (!st.empty() && st.peek()>=arr[i]){
                st.pop();
            }
            if(!st.empty()){
                ans[i]=st.peek();
            }else{
                ans[i] = -1;
            }
            st.push(arr[i]);
        }
        return ans;

    }
}
