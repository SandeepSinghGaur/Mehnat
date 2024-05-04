package Intermediate.SubSequenceAndSubset;

public class LittlePonnyAnd2Subsequence {
    public static void main(String[] args) {
        String s = "ksdjgha";
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        char firstChar = 'z';
        int index =0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)<firstChar){
                firstChar = s.charAt(i);
                index = i;
            }
        }
        String res= STR."\{firstChar}";
        char secondChar = 'z';
        boolean check = false;
        for(int i = index+1;i<s.length();i++){
            char p = s.charAt(i);
            if(secondChar>=firstChar && p<=secondChar){
                secondChar = s.charAt(i);
                check = true;
            }
        }
        if(!check) return "Not Present";

        return res+secondChar;
    }
}
