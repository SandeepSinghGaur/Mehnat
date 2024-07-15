package coreJava.java8.Ex5;

import java.util.Arrays;

public class RemoveNullAndEmpty {
    public static void main(String[] args) {
        String[] names = new String[]{"Durga","","Ravi","","Shiva",null};
        Arrays.stream(names).filter(e-> {
            if(e==null) return false;
            if(e.isEmpty()) return false;
            return true;
        }).forEach(System.out::println);
    }
}
