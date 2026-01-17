package DSA.string;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        boolean ans = checkAnagram(s1,s2);
       // System.out.println(STR."Is String Anagram  \{ans}");
    }

    private static boolean checkAnagram(String s1, String s2) {
        int[] count = new int[256];
        for(char ch : s1.toCharArray()){
            count[ch]++;
        }

        for(char ch : s2.toCharArray()){
            count[ch]--;
        }
        for(int val : count){
            if(val!=0) return false;
        }
        return true;
    }

    /*
    private static boolean checkAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        HashMap<Character,Integer> hs = new HashMap<>();
        for(Character ch : s1.toCharArray()){
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        for(Character ch : s2.toCharArray()){
            hs.put(ch,hs.getOrDefault(ch,0)-1);
        }
        for(int val : hs.values()){
            if(val>0) return false;
        }
        return true;

    }
     */
}
