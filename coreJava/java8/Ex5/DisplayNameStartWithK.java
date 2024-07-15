package coreJava.java8.Ex5;

import java.util.Arrays;
import java.util.List;

public class DisplayNameStartWithK {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kamata","Kareena","Kumar","Sandeep","Shivam","Khushbu");
        names.stream().filter(e->e.startsWith("K")).forEach(System.out::println);
    }
}
