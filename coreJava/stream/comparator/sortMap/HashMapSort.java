package coreJava.stream.comparator.sortMap;

import java.util.*;

public class HashMapSort {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("sandeep",99);
        map.put("Deepu",98);
        map.put("Vikas",100);
        map.put("Samayak",89);
        map.put("Amit",120);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list,Comparator.comparing(Map.Entry::getKey));
        //list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(STR."\{entry.getKey()}: \{entry.getValue()}");
        }
        System.out.println("=================================");
        list.sort(Comparator.comparing(Map.Entry::getKey));
        list.sort(Map.Entry.comparingByKey());
        list.forEach(e-> System.out.println(e.getKey()+" "+e.getValue()));
        System.out.println("==================Sort Array in Increasing order===============================");

        int[] arr = new int[]{10,2,0,-2,0,3,10,17};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(ele->System.out.printf(STR." \{ele}"));
        System.out.println();
        System.out.println("==================Sort Array in Decreasing order===============================");
        // Sort array in descending order using a Comparator
        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArray, Comparator.reverseOrder());
        int[] descendingArray = Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
        for(int ele : descendingArray){
            System.out.printf(STR." \{ele}");
        }
        System.out.println();

        System.out.println("===================Sort List===============================");


        List<Integer> ls = Arrays.asList(2,4,6,1,2,47,80,-1);
        Collections.sort(ls);
//        ls.sort(Comparator.reverseOrder());
//        ls.sort(Comparator.naturalOrder());
        //ls.sort(Comparator.comparing(Integer::intValue));
        Collections.sort(ls,Comparator.comparing(Integer::intValue));
        for(int i : ls){
            System.out.printf(STR." \{i}");
        }

        System.out.println();

        System.out.println("===================Sort List===============================");



    }
}
