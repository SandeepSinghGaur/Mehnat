package interview.string;

public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        String str = "SandeepSingh";
        System.out.println(reverseString(str));
        System.out.println(str.length());
    }

    private static String reverseString(String str) {
        if(str.length()==0) return "";
        char last = str.charAt(str.length()-1);
        return Character.toString(last)+reverseString(str.substring(0,str.length()-1));
    }
}
