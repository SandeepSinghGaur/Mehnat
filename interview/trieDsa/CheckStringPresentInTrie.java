package interview.trieDsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CheckStringPresentInTrie {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sandeep","Vikas","Deepu","Aswin","Amit","Mayank","Manju");
        Trie root = new Trie();
        InsertNamesInTrie(names,root);
        System.out.println(STR."Aswin is Present \{findWord("Aswi", root)}");


    }

    private static Boolean findWord(String str, Trie root) {
        Trie curr = root;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!curr.child.containsKey(ch)){
                return false;
            }
            curr = curr.child.get(ch);
        }
        if(curr.isEnd)
        return true;
        return false;
    }

    private static void InsertNamesInTrie(List<String> names,Trie root) {
        for(String str : names){
            insertIntoTrie(str,root);
        }
    }

    private static void insertIntoTrie(String str,Trie root) {
        Trie curr = root;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!curr.child.containsKey(ch)){
                curr.child.put(ch,new Trie());
            }
            curr = curr.child.get(ch);
        }
        curr.isEnd = true;

    }

    public static class Trie{
        HashMap<Character,Trie> child ;
        int count;
        boolean isEnd;
        Trie(){
            this.isEnd = false;
            this.count = 0;
            this.child = new HashMap<>();
        }
    }
}
