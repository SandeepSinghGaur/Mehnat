package interview.stream.comparator.sortMap;

import java.util.*;

public class HashMapSort {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("sandeep",99);
        map.put("Deepu",98);
        map.put("Vikas",100);
        map.put("Smayak",89);
        map.put("Amit",120);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(STR."\{entry.getKey()}: \{entry.getValue()}");
        }

    }
}
