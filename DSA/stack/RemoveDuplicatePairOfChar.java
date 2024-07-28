package DSA.stack;

import java.util.Stack;
import java.util.stream.Stream;

public class RemoveDuplicatePairOfChar {
    public static void main(String[] args) {
        String str = "acbbck";
        System.out.println(removeDuplicatePair(str));
    }

    private static String removeDuplicatePair(String str) {
        Stack<Character> st = new Stack<>();
        for (int i=0;i<str.length();i++){
            if(!st.isEmpty() && st.peek()==str.charAt(i)){
                st.pop();
            }else{
                st.push(str.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        return sb.reverse().toString();
    }
}
