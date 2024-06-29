package DSA.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



public class CalculatePrefix {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ram","raj","rahul","ramesh","ramshee","sonam","sonal");
        Trie root = new Trie();
        InsertNameInTrie(names,root);
        int ans = calculatePrefix("son",root);
        System.out.println(ans);

    }

    private static int calculatePrefix(String prefix, Trie root) {
        Trie curr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(curr.child.containsKey(ch)){
                curr = curr.child.get(ch);
            }
        }
        return curr.count;
    }

    private static void InsertNameInTrie(List<String> names, Trie root) {
        for(String str : names){
            insertInTrie(root,str);
        }
    }

    private static void insertInTrie(Trie root, String str) {
        Trie curr = root;
        for(int i=0;i<str.length();i++){
            char  ch = str.charAt(i);
            if(!curr.child.containsKey(ch)){
                curr.child.put(ch,new Trie());
            }
            curr = curr.child.get(ch);
            curr.count++;
        }
        curr.isEnd = true;
    }

    public static class Trie{
        HashMap<Character,Trie> child;
        int count;
        Boolean isEnd;

        Trie(){
            this.child = new HashMap<>();
            this.count = 0;
            this.isEnd = false;
        }

    }
}
