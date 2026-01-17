package designPattern.designPattern.structuralDesignPattern.facade;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> al = List.of("apple","pen");
        boolean ans = wordBreak(s,al);

    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> check = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            check.add(wordDict.get(i));
        }
        LinkedHashMap<Character,Integer> hs = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(hs.containsValue(s.charAt(i))){
                hs.put(s.charAt(i),hs.get(s.charAt(i))+1);
            }else{
                hs.put(s.charAt(i),1);
            }
        }
        System.out.println(hs);
        return true;
    }
}
